#include <stdio.h>
#include <stdlib.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <unistd.h>
#include <errno.h>
#include <string.h>
#include <sys/types.h>

int main(int argc, char *argv[])
{
    int sockfd, portno, n;

    struct sockaddr_in serv_addr;
    struct hostent *server;

    char buffer[256];
    if (argc < 5) {
       printf("usage %s hostname port source destination\n", argv[0]);
       exit(0);
    }
    portno = atoi(argv[2]);
    sockfd = socket(AF_INET, SOCK_STREAM, IPPROTO_TCP); //check slides
    if (sockfd < 0) 
    {
        printf("ERROR opening socket");
	  exit(0);
    }
    
    if (server == NULL) {
        fprintf(stderr,"ERROR, no such host\n");
        exit(0);
    }

    printf("setting sever address\n");
    memset(&serv_addr, '0', sizeof(serv_addr));
    serv_addr.sin_family = AF_INET;
    if(inet_pton(AF_INET, argv[1], &serv_addr.sin_addr)<=0)
    {
        printf("\n inet_pton error occured\n");
        return 1;
    } 
    serv_addr.sin_port = htons(portno);

    printf("about to connect");
    if (connect(sockfd,(struct sockaddr *)&serv_addr,sizeof(serv_addr)) < 0) //hint: server address
    { 
        //error("ERROR connecting");
        printf("error connecting");
        exit(0);
    }
    memset(buffer,0,sizeof(buffer));
    sprintf(buffer,"%s %s",argv[3],argv[4]);  //concat source and destination in a string and send to server
    
    n = write(sockfd, buffer, sizeof(buffer)); //size of might be wrong
    if (n < 0) 
         error("ERROR writing to socket");

    memset(buffer,0,sizeof(buffer));
    while ( (n = read(sockfd, buffer, sizeof(buffer)-1)) > 0)
    {
        buffer[n] = 0;
    }
    
    printf("The cost of shortest path from %s to %s is %s\n", argv[3], argv[4], buffer);
    
    return 0;
}
