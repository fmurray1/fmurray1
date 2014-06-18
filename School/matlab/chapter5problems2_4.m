% Problem 2

xD = [-5:10];
xR = (xD.*pi)./180;
y = ((5*sin(xR))/(xR+exp(-0.75.*xR)))-(3.*xR/5);
plot(xR,y)

%problem 4
figure
fplot('sqrt(abs(cos(3*x)))+ (sin(4*x)^2)', [-2,2])