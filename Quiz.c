#include<stdio.h>
#include<string.h>
#include<stdlib.h>

int main()
{
    char option1, option2, option3, option4, option5;
    int secmark1 = 0 ,secmark2 = 0,secmark3 = 0;
    printf("Section I - Single Correct MCQ's \n");
    printf("Section II - Multiple Correct MCQ's\n");
    printf("Section III - Fill in the blanks\n ");
    printf("===================================================\n");

    printf("\n## Single Correct MCQ's ");
    printf("\n*Rules*\n");
    printf("-->Each question carries 5 marks \n");
    printf("-->Wrong answer will have a negative marking of 1 mark\n");
    printf("-->Invalid input will be considered as wrong answer\n");

    printf("\nQ1) - Who among the following has held 2 full terms as President of India ?\n");
    printf("Options: a) Abdul Kalam \n b) Rajendra Prasad \n c) Pratibha Patil \nd) Zakir Husain\n");
    scanf("%s", &option1);
    if(option1=='b') secmark1+=5 ;

    printf("\nQ2) - Who was the 44th President of USA ?\n");
    printf("Options: a) Barack Obama \n b) Donald Trump \n c) Joe Biden \n d) George W. Bush\n");
    scanf("%s", &option2);
    if(option2=='a') secmark1+=5 ;

    printf("\nQ3) - Who was the 1st prominent emperor of the Mughal Empire ?\n");
    printf("Options: a) Akbar \n b) Babur \n c) Humayun \nd) Shah Jahan \n");
    scanf("%s", &option3);
    if(option3=='b') secmark1+=5 ;

    printf("\nQ4) - What kind of soil is the most fertile in India ?\n");
    printf("Options: a) Alluvial Soil \n b) Clayey Soil \n c) Sandy Soil\n d) Deserty Soil\n");
    scanf("%s", &option4);
    if(option4=='a') secmark1+=5 ;

    printf("\nQ5) - Who among the following was the 1st Female Governer in India?\n");
    printf("Options: a) Sarojini Naidu \n b) Padmaja Naidu \n c) Sharda Mukherjee \nd) Pratibha Patil\n");
    scanf("%s", &option5);
    if(option5=='a') secmark1+=5 ;

    printf("===================================================\n");

    printf("## Multi Correct MCQ's\n");
    printf("*Rules*\n");
    int i,j,k,l;
    printf("--> Each Question carries 4 marks \n");
    printf("--> You will be awarded partial marking of 1 mark.\n");
    printf("--> There is NO negative marking\n\n");
    printf("--> If two options (1 and 2) are correct, then enter the input as 12. \n\n");

    printf("Question 1 :Which of the following are Perfect Numbers ?(Perfect Number is a positive integer that is equal to the sum of its proper divisors)\n");
    printf("options    : 1) 6     \n");
    printf("             2) 64     \n");
    printf("             3) 30    \n");
    printf("             4) 28 \n");
    scanf("%d",&i);
    if (i==14) {secmark2+=4 ;}
    if (i== 1 || i ==4)secmark2=1 ;

    printf("\nQuestion 2 :Which of the following are Planets\n");
    printf("options    : 1) Pluto     \n");
    printf("             2) Uranus     \n");
    printf("             3) Neptune   \n");
    printf("             4) Proxima Centauri \n");
    scanf("%d",&j);
    if (j==23) {secmark2+=4 ;}
    if (j== 2 || j ==3)secmark2=1 ;

    printf("\nQuestion 3 :Which of the following Cricketer retired in 2020?\n");
    printf("options    : 1) Raina     \n");
    printf("             2) AB De Villers     \n");
    printf("             3) MS Dhoni   \n");
    printf("             4) Rahul Dravid \n");
    scanf("%d",&k);
    if (k==13) {secmark2+=4 ;}
    if (k== 1 || k ==3)secmark2=1 ;

    printf("\nQuestion 4 :Which of the following Car companies have animals in their symbols? \n");
    printf("options    : 1) Lamborghini     \n");
    printf("             2) Ferrari     \n");
    printf("             3) Benz   \n");
    printf("             4) BMW \n");
    scanf("%d",&j);
    if (j==12) {secmark2+=4 ;}
    if (j== 1 || j ==2)secmark2=1 ;
    printf("===================================================\n");

    printf("Fill In The Blanks\n");
    char opt1[30], opt2[30];
    printf("*Rules*\n");
    printf("--> The answer consists of only ONE word.\n");
    printf("--> Marking Scheme is +3 and no negative marks.\n");




    printf("\nWorld's most populated continent is: \n");
    scanf("%s",opt1);
    char a1[] = "asia";
    char a2[] = "Asia";
    char a3[] = "aSia";
    char a4[] = "asiA";
    char a5[] = "asIa";
    char a6[] = "ASia";
    char a7[] = "aSIa";
    char a8[] = "asIA";
    char a9[] = "AsiA";
    char a10[] = "AsIa";
    char a11[] = "aSiA";
    char a12[] = "aSIA";
    char a13[] = "AsIA";
    char a14[] = "ASiA";
    char a15[] = "ASIa";
    char a16[] = "ASIA";
    if (strcmp(a1,opt1) == 0)
    {
        secmark3 +=3;
    }
    if (strcmp(a2,opt1) == 0)
    {
        secmark3 +=3;
    }
    if (strcmp(a3,opt1) == 0)
    {
        secmark3 +=3;
    }
    if (strcmp(a4,opt1) == 0)
    {
        secmark3 +=3;
    }
    if (strcmp(a5,opt1) == 0)
    {
        secmark3 +=3;
    }
    if (strcmp(a6,opt1) == 0)
    {
        secmark3 +=3;
    }
    if (strcmp(a7,opt1) == 0)
    {
        secmark3 +=3;
    }
    if (strcmp(a8,opt1) == 0)
    {
        secmark3 +=3;
    }
    if (strcmp(a9,opt1) == 0)
    {
        secmark3 +=3;
    }
    if (strcmp(a10,opt1) == 0)
    {
        secmark3 +=3;
    }
    if (strcmp(a11,opt1) == 0)
    {
        secmark3 +=3;
    }
    if (strcmp(a12,opt1) == 0)
    {
        secmark3 +=3;
    }
    if (strcmp(a13,opt1) == 0)
    {
        secmark3 +=3;
    }
    if (strcmp(a14,opt1) == 0)
    {
        secmark3 +=3;
    }
    if (strcmp(a15,opt1) == 0)
    {
        secmark3 +=3;
    }
    if (strcmp(a16,opt1) == 0)
    {
        secmark3 +=3;
    }

    printf("\nGreek God of Sky & Thunder is: \n");
    scanf("%s",opt2);

    char b1[] = "zeus";
    char b2[] = "Zeus";
    char b3[] = "zEus";
    char b4[] = "zeUs";
    char b5[] = "zeuS";
    char b6[] = "ZEus";
    char b7[] = "zEUs";
    char b8[] = "zeUS";
    char b9[] = "ZeuS";
    char b10[] = "ZeUs";
    char b11[] = "zEuS";
    char b12[] = "ZEUs";
    char b13[] = "zEUS";
    char b14[] = "ZeUS";
    char b15[] = "ZEuS";
    char b16[] = "ZEUS";

    if (strcmp(b1,opt2) == 0)
    {
        secmark3 +=3;
    }
    if (strcmp(b2,opt2) == 0)
    {
        secmark3 +=3;
    }
    if (strcmp(b3,opt2) == 0)
    {
        secmark3 +=3;
    }
    if (strcmp(b4,opt2) == 0)
    {
        secmark3 +=3;
    }
    if (strcmp(b5,opt2) == 0)
    {
        secmark3 +=3;
    }
    if (strcmp(b6,opt2) == 0)
    {
        secmark3 +=3;
    }
    if (strcmp(b7,opt2) == 0)
    {
        secmark3 +=3;
    }
    if (strcmp(b8,opt2) == 0)
    {
        secmark3 +=3;
    }
    if (strcmp(b9,opt2) == 0)
    {
        secmark3 +=3;
    }
    if (strcmp(b10,opt2) == 0)
    {
        secmark3 +=3;
    }
    if (strcmp(b11,opt2) == 0)
    {
        secmark3 +=3;
    }
    if (strcmp(b12,opt2) == 0)
    {
        secmark3 +=3;
    }
    if (strcmp(b13,opt2) == 0)
    {
        secmark3 +=3;
    }
    if (strcmp(b14,opt2) == 0)
    {
        secmark3 +=3;
    }
    if (strcmp(b15,opt2) == 0)
    {
        secmark3 +=3;
    }
    if (strcmp(b16,opt2) == 0)
    {
        secmark3 +=3;
    }


    printf("\nResults ---");
    printf("Section 1 - %d/25 \nSection 2 - %d/16 \nSection 3 - %d/6 \n",secmark1,secmark2,secmark3);
    printf("Your Marks: %d \n",secmark1+secmark2+secmark3);
    printf("Total Marks: 47");

}
