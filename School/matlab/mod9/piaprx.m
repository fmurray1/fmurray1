m = input('Enter the value of m: ');

apx = 0;

for n=0:m

	apx = apx + ((-1/3)^n)/(2*n+1);
	
end

apx = sqrt(12)*apx;

format long;

disp(apx)
disp('')
disp(pi)
