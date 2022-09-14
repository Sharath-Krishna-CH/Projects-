#include <stdio.h>
#include <string.h>
#include <time.h>

#define size 3
void Clear(char (*)[size]);
void Players_turn(char (*)[size],char);
void PC_turn(char (*)[size],char,char,int*);
void Print_board(char (*)[size]);
void Scan_corners(char (*)[size],char,char);
int Check_board(char (*)[size],char,int*);
int Action(char (*)[size],char,char,int);
int Scan_diag(char (*)[size],char,char,int);
int Scan_rowscolumns(char (*)[size],char,char,int);




int main()
{
char xo[size][size]={'1','2','3','4','5','6','7','8','9'};
char Fig_PC='X';
char Fig_Players='O';
int PC_move=0;
printf("Welcome to Tic Tac Toe, Here You will Play Against A PC...... \n");
printf("All The Best.., Try Not to Lose! \n");

Print_board(xo);
Clear(xo);
PC_turn(xo,Fig_PC,Fig_Players,&PC_move);
while ((Check_board(xo,Fig_PC,&PC_move)))
{
Players_turn(xo,Fig_Players);
PC_turn(xo,Fig_PC,Fig_Players,&PC_move);
}
return 0;
}
void PC_turn(char (*xo)[size],char Fig_PC,char Fig_Players,int *PC_move)
{
printf("Computer's Turn Now:...\n");
if (!Action(xo,Fig_PC,Fig_Players,1))
    {
        if (!Action(xo,Fig_Players,Fig_PC,0))
        {
            Scan_corners(xo,Fig_PC,Fig_Players);
        }
    }

    Print_board(xo);
    ++*PC_move;
}


void Print_board(char (*xo)[size])
{
int i=0;

        printf("\n\n   |   |    \n");
        printf(" %c | %c | %c\n", xo[2][0], xo[2][1], xo[2][2]);
        printf("___|___|___ \n");
        printf("   |   |    \n");
        printf(" %c | %c | %c\n", xo[1][0], xo[1][1], xo[1][2]);
        printf("___|___|___ \n");
        printf("   |   |    \n");
        printf(" %c | %c | %c\n", xo[0][0], xo[0][1], xo[0][2]);
        printf("   |   |    \n\n\n");
}


void Clear(char (*xo)[size])
{
    int g=0;
    int h=0;

    for (g=0;g<size;++g)
    {
        for (h=0;h<size;++h)
        {
        xo[g][h]=' ';
        }
    }
}



void Players_turn(char (*xo)[size], char Fig_Players)
{

int choice=0;
printf("Player's Turn Now:.\n");
printf("Choose  %c position now....\n", Fig_Players);

while ((choice<1) || (choice>9))
{
    scanf("%d",&choice);
    if ((choice>0) && (choice<10) && (xo[(choice-1)/size][(choice-1)%size]==' '))
    {
    xo[(choice-1)/size][(choice-1)%size]=Fig_Players;
    Print_board(xo);
    }
    else
    {
    printf("Please try again......\n");
    }
}
}



int Action(char (*xo)[size],char Fig_PC,char Fig_Player, int Action)
{
    int diags=0;
    int rowscols=0;

    diags = Scan_diag(xo,Fig_PC,Fig_Player,Action);
    rowscols = Scan_rowscolumns(xo,Fig_PC,Fig_Player,Action);

    if (rowscols || diags)
    {
        return 1;
    }

    return 0;

}


int Scan_diag(char (*xo)[size],char Attk_fig,char Def_fig,int Action)
{
    int g=0;
    int index=0;
    int count_diag=0;

    for (g=0;g<size;++g)
    {
        if (xo[g][g]==Attk_fig)
        {
            ++count_diag;
        }
        else if (xo[g][g]==' ')
        {
            count_diag+=100;
            index=g;
        }
    }

    if (count_diag==102)
    {
        if (Action)
        {

        xo[index][index]=Attk_fig;
        return 1;
        }

        xo[index][index]=Def_fig;
        return 1;
    }

    return 0;
}



int Scan_rowscolumns(char (*xo)[size],char Attk_fig,char Def_fig,int Action)
{
    int g=0;
    int h=0;
    int index1=0;
    int index2=0;
    int count_row=0;
    int count_col=0;

    for (g=0;g<size;++g)
    {
        for (h=0;h<size;++h)
        {
             if (xo[g][h]==Attk_fig)
             {
                 ++count_row;
             }
             else if (xo[g][h]==' ')
             {
                 count_row+=100;
                 index1=h;
             }
             if (xo[h][g]==Attk_fig)
             {
                 ++count_col;
             }
             else if (xo[h][g]==' ')
             {
                 count_col+=100;
                 index2=h;
             }
        }


        if (count_row==102)
        {
            if (Action)
            {
                xo[g][index1]=Attk_fig;
                return 1;
            }
            else
            {
                xo[g][index1]=Def_fig;
                return 1;
            }
        }
        else
        {
            count_row=0;
        }


        if (count_col==102)
        {
            if (Action)
            {
                xo[index2][g]=Attk_fig;
                return 1;
            }
            else
            {
                xo[index2][g]=Def_fig;
                return 1;
            }
        }
        else
        {
            count_col=0;
        }

    }

    return 0;
}



void Scan_corners(char (*xo)[size],char Fig_PC,char Fig_Player)
{
    int g=0;
    int h=0;
    int gg=0;
    int hh=0;
    int count=0;

    for (g=0;g<size;g+=(size-1))
    {
        for (h=0;h<size;h+=(size-1))
        {
            if (xo[g][h]==' ')
            {
                ++count;
                gg=g;
                hh=h;
            }
        }
    }
    switch (count)
    {
    case 1:
        xo[gg][hh]=Fig_PC;
        break;


    case 2:
        if ((xo[0][size-1]==Fig_PC) || (xo[0][size-1]==Fig_Player))
        {
            xo[0][0]=Fig_PC;
        }
        else
        {
            xo[0][size-1]=Fig_PC;
        }
        break;


    case 3:
        if (xo[((size-1)/2)][((size-1)/2)]==Fig_Player)
        {
            xo[0][size-1]=Fig_PC;
        }
        else if (xo[size-2][0]==Fig_Player)
        {
            xo[size-1][size-1]=Fig_PC;
        }
        else
        {
            xo[0][0]=Fig_PC;
        }
        break;


    case 4:
        xo[size-1][0]=Fig_PC;
        break;
    }
}


int Check_board(char (*xo)[size],char Fig_PC, int *PC_move)
{
    int g=0;
    int h=0;
    int count_row=0;
    int count_col=0;
    int count_diag1=0;
    int count_diag2=0;

    if (*PC_move==5)
    {
        printf("It's a draw.... You Did Well!!!\n\n");
        return 0;
    }


    for (g=0;g<size;++g)
    {
        if (xo[g][g]==Fig_PC)
        {
            ++count_diag1;
        }

        if (xo[g][(size-1)-g]==Fig_PC)
        {
            ++count_diag2;
        }

        for (h=0;h<size;++h)
        {
            if (xo[g][h]==Fig_PC)
            {
                ++count_row;
            }

            if (xo[h][g]==Fig_PC)
            {
                ++count_col;
            }
        }
        if ((count_row==size) || (count_col==size))
        {
            printf("PC wins!!!!!\n\n");
            return 0;
        }
        else
        {
            count_row=0;
            count_col=0;
        }
    }

    if ((count_diag1==size) || (count_diag2==size))
    {
        printf("PC wins!!!!\n\n");
        return 0;
    }


return 1;

}
