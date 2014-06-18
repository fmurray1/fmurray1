//look at the sudo code for this on ecampus!!!!!

#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

//need to add the structs for vert and edge

void shortPath(int, int, int);
void printPath(int , int, int[], int [], int);
int getCost(int, int);
int done(int [], int);
struct edge
  {
    int vertexIndex;
    int vertexWeight;
    struct edge *edgePtr;
  }edge;
  
  struct vertex
  {
    int vertexKey;
    struct edge *edgePtr;
    struct vertex *vertexPtr;
  }vertex;
int numNodes;
int source;
int dest;
struct vertex *start;

int main(int argc, char *argv[])
{
  numNodes = atoi(argv[2]);
  source= atoi(argv[3]);
  dest= atoi(argv[4]);
  struct vertex *currvertex;
  struct edge *curredge;
  int cw;
  FILE *fp; //declares a file pointer
  FILE *test;
  fp = fopen(argv[1], "r"); //sets the filepointer to the file specified from the cmd line
  test = fp;
  int testData = INT_MIN;
  int testLines= 0;
  if(fp == NULL) //makes sure the file is really there
    {
      printf("There was an error with the file name.\n");
      exit(0);
    }
  else
    {
      while(!feof(test))
	{
	  fscanf(test, "%d",&testData);
	  testLines ++;
	}
    }
  if(testData == INT_MIN && testLines == 1)
    {
      printf("There is no data in the file.\n");
      exit(0);
    }
  else if(numNodes == 1)
    {
      printf("There is only one node, there is no path.\n");
      exit(0);
    }
  else if(testLines > (numNodes* numNodes))
    {
      printf("There was an error in file.\n");
      exit(0);
    }
  else if(dest > numNodes || source > numNodes)
    {
      printf("There was an error with your starting or ending location.\n");
      exit(0);
    }
  else
    {
      fp = fopen(argv[1], "r");
      int i;
      for (i=0; i<numNodes; i++)
	{
	  struct vertex *v =  (struct vertex *)malloc(sizeof(struct vertex)); //?? allocate space for vertex ??
	  v->vertexKey= i; //node vertex id is equal to the current row number; no need for fscanf
	  v->edgePtr=NULL;
	  v->vertexPtr=NULL;
	  
	  if (start==NULL)
	    {
	      start= v;
	      currvertex = v;
	    }
	  else
	    {
	      currvertex -> vertexPtr = v;
	      currvertex = v;
	    }
	  
	  
	  int j;
	  for (j=0; j<numNodes; j++)
	    {
	      struct edge *e = (struct edge *)malloc(sizeof(struct edge)); //allocate space for edge
	      if (!feof(fp)) 
		{
		  fscanf(fp, "%d", &cw); //read the edge weight into variable cw
		}
	      else 
		{
		  //print error as too few arguments, close the file and exit
		  printf("There was an error with the file.\n");
		  fclose(fp);
		  exit(0);
		}
	      
	      if (cw<=0) {}  //if edge weight is 0 or -1, no need to create new edge
	      else if(cw != 0 && i == j)
		{
		  fclose(fp);
		  exit(0);
		}
	      else 
		{
		  e->vertexWeight = cw;
		  e->vertexIndex = j;
		  e->edgePtr = NULL;
		}
	      
	      if (v->edgePtr == NULL)  //first edge for this vertex
		{
		  v->edgePtr= e;
		  curredge = e;
		}
	      else
		{
		  curredge -> edgePtr = e;
		  curredge = e;
		} 
	    }
	  curredge -> edgePtr = NULL;
	}
      currvertex -> vertexPtr = NULL;
    }
  fclose(fp);
  shortPath(source, dest, numNodes);
  return 0;
}

void shortPath(int source, int dest, int numNodes)
{
  int dist[numNodes];
  int comp[numNodes];
  int prev[numNodes];
  int i;
  struct vertex *curVert = start;
  struct edge *curEdge;
  dist[source] = 0;
  comp[source] = 1;
  prev[source] = source;
  int currentNode;
  int new;
  int k;
  int min = INT_MAX;
  
  printf("entering shortest path\n");
  for(i=0; i < numNodes; i++)
    {
      printf("first for loop\n");
      if(i != source)
	{
	  printf("i != source\n");
	  dist[i] =  INT_MAX;
	  printf("set dist[i] to int max\n");
	  comp[i]=0;
	  printf("set comp [i] to 0\n");
	  prev[i] =  INT_MIN;
	  printf("set prev[i] to int min\n"); 
	}
    }
  printf("out of first for loop\n");
  currentNode = source;
  while(done(comp, numNodes) != 1)
    {
      printf("entering while loop\n");
      k = -1;
      i = 0;
      for(i; i < numNodes; i++)
	{
	  if(comp[i] == 0)
	    {
	      printf("comp[i] == 0\n");
	      printf("dist[currentNode]:%d\n",dist[currentNode]);
	      new = dist[currentNode] + getCost(currentNode, i);
	      printf("set new\n");
	      if(new >= INT_MAX && i == (numNodes-1) && min >= INT_MAX)
		{
		  printf("long as if statement\n");
		  comp[i] = 1;
		}
	      else if (new < dist[i])
		{
		  printf("new < dist[i]\n");
		  dist[i] = new;
		  prev[i] = currentNode;
		}
	      if (dist[i] < min)
		{
		  printf("dist[i] < min");
		  min = dist[i];
		  k = i;
		}
	    }
	}
      if(k == -1)
	{
	  break;
	}
      else
	{
	  currentNode = k;
	  comp[currentNode] = 1;
	}
    }
  printPath(source, dest, prev, dist, numNodes);
}

void printPath(int source, int dest, int prev[], int dist[], int numNodes)
{
  int i;
  int pathLen= 0;
  printf("entering print path\n");
  if(prev[dest] == -1)
    {
      printf("No path exists.\n");
    }
  else
    {
      printf("entering else of print path\n"); 
      int i= dest;
      while(i != source)
	{
	  printf("while i!= source\n");
	  pathLen++;
	  printf("incremented path length\n");
	  i=prev[i];
	  printf("set i = prev[i]");
	  printf("i:%d\n", i);
	}
      printf("made it out of the for loop\n");
      int path[pathLen];
      printf("made path array\n");
      i = dest;
      printf("set i to dest\n");
      int j=0;
      printf("set int j to 0\n");
      for(j; j< pathLen; j++)
	{
	  printf("next for loop with j var\n");
	  path[j] = i;
	  i = prev[i];
	} 
      printf("%d", path[pathLen]);
      
      for(j = pathLen-1; j >=0; j--)
	{
	  printf("-%d", path[j]);
	}
      printf(":%d\n", dist[dest]);
    }
}

int done(int comp[], int numNodes)
{
  printf("checking if this is done?");
  int i=0;
  while(i < numNodes)
    {
      if(comp[i] == 0)
	{
	  return 0;
	}
      i++;
    }
  return 1;
}

int getCost(int current, int i)
{
  struct vertex *currV; 
  struct edge *currE;

  currV = start;
    
  while (currV != NULL && currV->vertexKey != current)
    {
      currV=currV->vertexPtr;
    }
    
  if (currV != NULL)
    {
      currE = currV->edgePtr;
    }
    
  while (currE != NULL && currE->vertexIndex != i)
    {
      currE = currE->edgePtr;
    }
    
  if (currE == NULL || currE->vertexWeight == 0)
    {
      printf("returning max cost\n");
      return INT_MAX;
    }
  else
    {
      printf("cost:%d\n",currE->vertexWeight);
      return currE -> vertexWeight;
    }
}
