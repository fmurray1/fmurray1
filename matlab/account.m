format bank;
A = 10000;
r = [.02:.005:.06];
n = 10;
B = [A* (1 + (r/100)).^n];
table = [r', B'];
disp('       Percent (%)  Ammount ($)')
disp(table)

fid = fopen('prob6.txt', 'w');
fprintf(fid, 'Percent    Ammount \n');
fprintf(fid,'%f', table);
%table;
fclose(fid);