disp('case 1')
R=[];
count = 0;
for i=1:1:10
    
    R = [(95 + rand(1)*10), R]
    if R(i)<=101 && R(i) >= 99
        count = count + 1;
    end
end

P = (count*100)/i

% Plot Histogram!!



disp('case 2')

for i = 1:1:10000
y(i) = 1/(380 + 40 * rand(1)) + 1/(380 + 40 * rand(1)) + 1/(380 + 40 * rand(1)) + 1/(380 + 40 * rand(1));
R(i) = 1/y(i);
end

subplot(2,2,2);
hist(R),title('Monte Carlo Case 2');
xlabel ('Resistance in Ohms'), ylabel('Number of Resistors');

total = 0;

for i=1:1:10000

	if(R(i) >= 99 && R(i) <= 101)
	total = total +1;
	end
end

probability = total * 100 / 10000

