#include <stdio.h>
#include <stdbool.h>
#include <time.h>

void inputs(int sudoku[9][9])
{
    printf("  HI!!");

    printf("  \nThis Code Solves Sudoku on its own");

  printf("\nEnter The sudoku puzzle enter numbers by giving spaces and enter '0' for blank space and press enter after each line\n");

  printf("Please check once again if the format you have entered is matching with the required format.");

  printf("\nEnter the puzzle which need to be solved  \n");

  for(int g=0;g<9;g++)
    {
    for(int h=0;h<9;h++) scanf("%d",&sudoku[g][h]);
    getchar();
  }
  printf("\n\nThe following puzzle is completely Solved : \n");
}

void outputs(int sudoku[9][9]){
  for(int g=0;g<9;g++){
    for(int h=0;h<9;h++) printf(" %d ",sudoku[h][h]);
    printf("\n");
  }
}

bool saf(int sudoku[9][9],int rows,int columns,int value)
{
  bool row_check=true,col_check=true,submatrix_check=true;
  int g,h;
  for(h=0;h<9;h++)
   if(sudoku[rows][h]==value) row_check=false;
  for(g=0;g<9;g++)
   if(sudoku[g][columns]==value) col_check=false;
  for(g=0;g<3;g++)
   for(h=0;h<3;h++)
    if(sudoku[g+(rows-(rows%3))][h+(columns-(columns%3))]==value)
      submatrix_check=false;
  if(row_check==true&&col_check==true&&submatrix_check==true)
  return true;else return false;
}

bool sol(int sudoku[9][9],int rows,int columns){
  if(rows==8&&columns==9)return true;
  if(columns==9){rows++;columns=0;}
  if(sudoku[rows][columns]>0){++columns;return sol(sudoku,rows,columns);}
  for(int value=1;value<=9;value++){
	  if(saf(sudoku,rows,columns,value)){
			sudoku[rows][columns]=value;++columns;
			if(sol(sudoku,rows,columns))return true;else{
        if(columns==0){--rows;columns=8;}
        else --columns;
      }
		}
		sudoku[rows][columns]=0;
	}
	return false;
}

int main(void)
{
 int sudoku[9][9];
 inputs(sudoku);
 if(!sol(sudoku,0,0))
    {
   printf("\n\nThe puzzle which you gave is invalid. try with new puzzle or check the format again!!\n\n");
   return 0;
 }
 outputs(sudoku);
 return 0;
}
