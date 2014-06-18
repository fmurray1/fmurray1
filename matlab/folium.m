t1 = [linspace(-30, -1.6, 200)];
t2 = [linspace(-0.6, 40, 200)];

x = [3.*t1/(1+ t1.^3)];
y = [(3.*t2.^2)/(1+ t2.^3)];

plot(t1,x,t2,y)
xlabel('Time')
ylabel('Function of time')
title('Folium of Descartes')