a = 34172;
b = 7.9622;
C = [0:2:42];
T = [273+C];
p = [10.^(b-(0.05223*a)./T)];
table = [C', p']; 
disp('       Degrees(C)  Pressure (mmHg)')
disp(table)