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
	  printf("in test area\n");
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
      printf("omg made it to the last else\n");
      int i;
      for (i=0; i<numNodes; i++)
	{
	  printf("making stuffs\n");
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
	      printf("j:%d\n",j);
	      if (!feof(fp)) 
		{
		  printf("oh la la reading from the file\n");
		  printf("cw:%d\n", cw);
		  fscanf(fp, "%d", &cw); //read the edge weight into variable cw
		}
	      else 
		{
		  //print error as too few arguments, close the file and exit
		  printf("There was an error with the file.\n");
		  fclose(fp);
		  exit(0);
		}
	      
	      if (cw<=0) {printf("not making an edge!!!!!!\n");}  //if edge weight is 0 or -1, no need to create new edge
	      else if(cw != 0 && i == j)
		{
		  printf("CW:%d\n",cw);
		  printf("I:%d\n", i);
		  printf("J:%d\n",j);
		  printf("Invalid Edge.\n");
		  fclose(fp);
		  exit(0);
		}
	      else 
		{
		  printf("making edge\n");
		  printf("setting edge weight to: %d\n", cw);
		  e->vertexWeight = cw;
		  e->vertexIndex = j;
		  e->edgePtr = NULL;
		}
	      
	      if (v->edgePtr == NULL)  //first edge for this vertex
		{
		  printf("first edge of the vert\n");
		  v->edgePtr= e;
		  curredge = e;
		}
	      else
		{
		  printf("another edge\n");
		  curredge -> edgePtr = e;
		  curredge = e;
		} 
	    }
	  curredge -> edgePtr = NULL;
	}
      currvertex -> vertexPtr = NULL;
    }
  printf("trying to close the file");
  fclose(fp);
  shortPath(source, dest, numNodes);
  return 0;
}

void shortPath(int source, int dest, int numNodes)
{
  int dist[numNodes];
  int comp[numNodes];
  int prev[numNodes];
  int i = 1;
  struct vertex *curVert = start;
  struct edge *curEdge;
  dist[source] = 0;
  comp[source] = 1;
  prev[source] = source;
  int currentNode;
  int new;
  int k;
  int min;

  for(i; i < numNodes; i++)
    {
      if(i != source)
	{
	  dist[i] = INT_MAX;
	  comp[i]=0;
	  prev[i] =  INT_MIN;
	}
    }

  while(done(comp, numNodes) != 1)
    {
      k = -1;
      for(i =0; i < numNodes; i++)
	{
	  if(comp[i] == 0)
	    {
	      new = dist[currentNode] + getCost(currentNode, i);
	      if(new >= INT_MAX && i == (numNodes-1) && min >= INT_MAX)
		{
		  comp[i] = 1;
		}
	      else if (new < dist[i])
		{
		  dist[i] = new;
		  prev[i] = currentNode;
		}
	      if (dist[i] < min)
		{
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
  if(prev[dest] == -1)
    {
      printf("No path exists.\n");
    }
  else
    {
      int i= dest;
      while(i != source)
	{
	  pathLen++;
	  i=prev[i];
	}
      int path[pathLen];
      i = dest;
      int j;
      
      for(j=0; j< pathLen; j++)
	{
	  path[j] = i;
	  i = prev[i];
	} 
      printf("$d", path[pathLen -1]);
      
      for(j = pathLen-2; j >=0; j--)
	{
	  printf("-%d", path[j]);
	}
      printf(":%d", dist[dest]);
    }
}

int done(int comp[], int numNodes)
{
  int i;
  while(i < numNodes)
    {
      if(comp[i] == 0)
	{
	  return 0;
	}
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
      return INT_MAX;
    }
  else
    {
      return currE->vertexWeight;
    }
}
