x=[-3.5, -5, 6.2, 11, 0, 8.1, -9, 0, 3, -1, 3, 2.5];

l = length(x);
p = [];
n = [];

for i=1:l
	
	if x(i) < 0
		
		n = [n, x(i)];
		
	elseif x(i) > 0
	
		p = [p, x(i)];
		
	end
	
end

fprintf('The positive values are:\n')
disp(p)
fprintf('The negative values are:\n')
disp(n)