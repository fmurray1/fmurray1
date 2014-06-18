%Module 7 Unit 3

    %Problem 1
    
    x = [0:.1:50];
    y1 = [(3.*x -x)];
    y2 = [(2.*x.^3 - 10.*x.^2 + 5)];
    
    plot(x,y1,x,y2)
    
    %Problem 2
    
    figure
    y3 = [((x.^2 - x + 1) - (x.^2 + x + 1))];
    y4 = [((x.^2 + x + 1) - (x.^2 - x + 1))];
    
    plot(x,y3)
    hold on
    plot(x, y4)
    hold off
    
    %problem 3
    
    figure
    x2 = [0:.001:10];
    y5 = [cos(x2)];
    y6 = [sin(x2)];
    
    plot(x2,y5)
    line(x2,y6)
    