s = [73, 91, 37, 81, 63, 66, 50, 90, 75, 43, 88, 80, 79, 69, 26, 82, 89, 99, 71, 59];

s = sort(s);

n = length(s)-8;
sum = 0;
for i=n:20

	sum = sum + s(i);

end

avg = sum/8;

fprintf('The average for the top 8 scores is %2.2f\n', avg)