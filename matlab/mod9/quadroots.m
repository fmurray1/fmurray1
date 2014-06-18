fprintf('Please enter the constants a,b, and c for the equation ax^2 + bx + c\n')

a = input('a = ');
b = input('b = ');
c = input('c = ');

d = b^2 - 4*a*c;

if d < 0

	fprintf('The equation has no real roots.\n')
	
elseif d == 0

	fprintf('The equation has one root.\n')

elseif d > 0

	fprintf('The equation has two roots.\n')
	
end
