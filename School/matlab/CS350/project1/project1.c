#include <stdio.h>
#include <stdlib.h>

float checkFl(char input[]);
int checkInt(char input[]); 
int toInt(char input[]); 
float toFloat(char input[]); 
void intParse(char input[]); 
char *toUpper(char input[]); 
char *toLower(char input[]); 
void reverseString(char input[]); 
void isPalindrome(char pal[]); 
void reverseWords(char input[]); 
void subsetCheck(char fullString[], char subString[]); 
void partialCopy(char string[], char start[]); 
int len(char input[]); 

int main(int argc, char *argv[])
{
  switch(toInt(argv[argc-1]))
    {
    case 1: 
      printf("%i\n", checkInt(argv[1]));
      break;
    case 2: 
      printf("%f\n", checkFl(argv[1]));
      break;
    case 3: 
      intParse(argv[1]);
      break;
    case 4: 
      printf("%s\n", toUpper(argv[1]));
      break;
    case 5: 
      printf("%s\n", toLower(argv[1]));
      break;
    case 6: 
      reverseString(argv[1]);
      break;
    case 7: 
      isPalindrome(argv[1]);
      break;
    case 8: 
      reverseWords(argv[1]);
      break;
    case 9: 
      subsetCheck(argv[1], argv[2]);
      break;
    case 10: 
      partialCopy(argv[1], argv[2]);
      break;
    default:
      printf("Error: Your selection did not match any of the available.\n");
      break;
    }
  return 0;
}

int len(char input[])
{
  int i = 1;
  while (input[i]!= '\0' )
    {
      i++;
    }
  return i;
}

char *toUpper(char input[])
{
  int i;
  char diff = 'a'-'A';
  int length = len(input);
  for(i=0; i < length; i++)
    {
      if(input[i] >= 'a' && input[i] <= 'z')
	{
	  input[i] -= diff; //subtract because capitals have a lower value
	}
    }
  return input;
}


char *toLower(char input[])
{
  int i;
  int length = len(input);
  char diff = 'a'-'A';
  for(i=0; i < length; i++)
    {
      if(input[i] >= 'A' && input[i] <= 'Z')
	{
	  input[i] += diff; //add because capitals have a lower value
	}
    }
  return input;
}



void reverseString(char input[])
{
  int length = len(input);
  for(length; length >= 0; length--)
    {
      printf("%c", input[length]);
    }
  printf("\n");
}

void isPalindrome(char pal[])
{
  int i, length;
  pal = toLower(pal);
  length= len(pal);
  for(i=0; i< length; i++)
    {
      if(pal[i] != pal[length-i-1])
	{
	  printf("The input string is not a palindrome.\n");
	  exit(0);
	}
    }
  printf("The input string is a palindrome.\n");
  exit(0);
}

void subsetCheck(char fullString[], char subString[])
{
  int i=0, j=0;
  int isSS =0;
  int substringLength = len(subString);
  int fullStringLength = len(fullString);
  while(i != fullStringLength)
    {
      while(fullString[i] != subString[0])
	{
	  i++;
	}
      for(j; j<substringLength; j++)
	{
	  if(fullString[i] == subString[j])
	    {
	      isSS = 1;
	      i++;
	    }
	  else 
	    {
	      isSS = 0;
	      break;
	    }
	}
      if(isSS =1)
	{
	  printf("The second string is a substring of the first.\n");
	  exit(0);
	}
    }
  printf("The second string is not a substring of the first.\n"); 
}

int checkInt(char input[])
{
  int i =0;
  if(input[0] == '-')
    {
      i++;
    }
  while(input[i] != '\0')
    {
      if(!(input[i]>='0' && input[i]<='9'))
	{
	  printf("Error: That string contained more than just numbers.\n");
	  exit(0);
	}
      i++;
    }
  return toInt(input);
}



int toInt(char input[])
{
  int output = 0;
  int length = len(input);
  int neg =0;
  int i = 0;
  if(input [0] == '-')
    {
      neg = 1;
      i++;
    }
  for(i; i<length; i++)
    { 
      output *= 10;
      output += (input[i]-'0');
    }
  if(neg == 1)
    {
      output *= (-1);
    }
  return output;
}

float toFloat(char input[])
{
  int dec =0;
  int neg =0;
  int i = 0;
  int length = len(input);
  float output = 0;
  float output2 = 0;
  if(input[0] == '-')
    {
      neg = 1;
      i++;
    }
  
  for(i; i<length; i++)
    { 
      if(input[i] == '.')
	{
	  dec = 1;
	}
      else if(dec != 0)
	{
	  output2 *=10;
	  output2 += (input[i]-'0');
	  dec++;
	}
      else
	{
	  output *= 10;
	  output += (input[i]-'0');
	}
    }
  while(dec > 1)
    {
      output2 /= 10;
      dec --;
    }
  output +=output2;
  if(neg == 1)
    {
      output *= (-1);
    }
  return (output);
}

float checkFl(char input[])
{
  int i =0;
  int dec = 0;
  if(input[0] == '-')
    {
      i++;
    }
  while(input[i] != '\0')
    {
      if(!(input[i]>='0' && input[i]<='9'))
	{
	  if(input[i] != '.' || dec != 0)
	    {
	      printf("Error: That string contained more than just numbers.\n");
	      exit(0);
	    }
	  dec++;
	}
      i++;
    }
  return toFloat(input);
}

void partialCopy(char input[], char start[]) //possibly change this to void
{
  int i = 0;
  while(input[i] != start[0] && input[i] != '\0')
    {
      i++;
    }
  if(input[i] != '\0')
    {
      while(input[i] != '\0')
	{
	  printf("%c", input[i]);
	  i++; 
	}
    }
  else
    {
      printf("Error: There is no matching character in the given string.");
    }
  printf("\n");
}

void reverseWords(char input[])
{
  int i = len(input), j=0;
  int tmp;
  while(i >=0)
    {
      while(input[i] != ' ' && i != 0)
	{
	  i--;
	}
      tmp = i -1;
      if(i != 0)
	{
	  i++;
	}
      while(input[i] != ' ' && input[i] != '\0' && i >= 0)
	{
	  printf("%c",input[i]);
	  i++;
	}
      printf(" ");
      i = tmp;
    }
  printf("\n");
}

void intParse(char input[])
{
  int out, i=0, j, start, end, length;
  length = len(input);
  while(i < length)
    {
      while((input[i] < '0' || input[i] > '9') && input[i] !='\0')
	{
	 i++;
	}
      start = i;
      while((input[i] >= '0' && input[i] <= '9') && input[i] !='\0')
	{
	  i++;
	}
      end = i;
      if(input[start] != '\0')
	{
	  out = 0;
	  for(j = start; j<end; j++)
	    {
	      out *=10;
	      out += (input[j]-'0');
	    }
	  if(start!=0 && input[start-1] == '-')
	    {
	      out *= (-1);
	    }
	  printf("%i ", out);
	}
    }
  printf("\n");
}
