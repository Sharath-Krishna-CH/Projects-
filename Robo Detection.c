#include <time.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

const char alphabet[] = "abcdefg%$&#hijRSklmn#^sMN>OvwxyzA`<:BC~D@EFG*56HIV1*^23459/,.+PQopqrTU%^&WXYZ0=-'@tu678JKL!_();";

int intN(int n) { return rand() % n; }

char *randomString(int len) {
  char *rstr = malloc((len + 1) * sizeof(char));
  int i;
  for (i = 0; i < len; i++)
  {
    rstr[i] = alphabet[intN(strlen(alphabet))];
  }
  rstr[len] = '\0';
  return rstr;
}

int prime(int n)
{

    int i;

     for(i=2; i<n; i++)
     {
       if (n%i==0)
       {
           return (0);
           break;
       }
       else
       {
            return(1);
            break;
       }
     }
}

int between (int n)
{
    if (n>137 && n<213)
       {
           return (1);
       }
    else
       {
            return(0);
       }
}

int main(int argc, char **argv)
{

  srand(time(NULL));
  int n,s,m;
  char *p;

  p = randomString(5);
  char *c;
  printf("%s\n", p);
  printf("Type the above characters as shown (case sensitive):");
  scanf("%s",c);
  printf("\n");
  if (strcmp(c, p) != 0)
  {
      printf("You are not a human.\n");
      exit(0);
  }
  free(p);

  printf("\nEnter a prime number: ");
  scanf("%d",&n);

  if(prime(n)==0)
  {
      printf("\nYou are not a human.\n");
      exit(0);
  }

  else
  {
      printf("\nNumber is a prime\n");
  }


  printf("\nEnter a number between 137 & 213: ");
  scanf("%d",&s);

  if(between(s)==0)
  {
      printf("\nYou are not a human.\n");
      exit(0);
  }

  else
  {
      printf("\nValid Input\n");
  }




  printf("\nEnter ANOTHER prime number: ");
  scanf("%d",&m);
  if (m==n)
  {
      printf("\nYou are not a human.\n");
      exit(0);
  }
  else if(prime(n)==0)
  {
      printf("\nYou are not a human.\n");
      exit(0);
  }

  else
  {
      printf("\nNumber is a prime\n");
  }

  printf("\nYou are a Human!\n");
  exit(0);

}

