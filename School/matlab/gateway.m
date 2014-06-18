x = [-694:694];
y = [693.8 - 68.8.*cosh(x./99.7)];

plot(x,y)
xlabel('Length(ft)')
ylabel('Arch')
title('Gateway Arch in St. Louis')
