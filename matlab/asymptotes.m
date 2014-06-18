xL = [-6:.0001:-0.0001];
xR = [0.0001:.0001:6];

yL = [((xL.^2 - 4.*xL - 7)/(xL.^2 - xL - 6))];
yR = [((xR.^2 - 4.*xR - 7)/(xR.^2 - xR - 6))];

plot(xL,yL,xR,yR)
axis([-7, 7, -20, 20]);