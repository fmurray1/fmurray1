TCH = [75, 79, 86, 86, 79, 81, 73, 89, 91, 86, 81, 82, 86, 88, 89, 90, 82, 84, 81, 79, 73, 69, 73, 79, 82, 72, 66, 71, 69, 66, 66];
TSF = [69, 68, 70, 73, 72, 71, 69, 76, 85, 87, 74, 84, 76, 68, 79, 75, 68, 68, 73, 72, 79, 68, 68, 69, 71, 70, 89, 95, 90, 66, 69];

n = length(TCH);
ACH = 0;

for i=1:n

	ACH = ACH + TCH(i);
	
end
	
ACH = ACH/n;

m = length(TSF);
ASF = 0;

for j=1:m
	
	ASF = ASF + TSF(i);
	
end

ASF = ASF/m;

DCH = 0;

for k=1:n
	
	if TCH(k) > ACH
			 
		 DCH = DCH + 1;
	end
end

DSF = 0;

for z=1:m
		
	if TSF(z) > ASF
			
		DSF = DSF + 1;
	
	end
end

fprintf('The average temperature for Chicago was: %5.2f\n', ACH)
fprintf('The number of days above the average temperature was: %2.0f\n', DCH)
fprintf('The average temperature for San Francisco was: %5.2f\n', ASF)
fprintf('The number of days above the average temperature was: %2.0f\n', DSF)
fprintf('The days the temperature was the same in both cities were:\n')

same = 0;

for y=1:n 
	
	if TSF(y) == TCH(y)
		
		same = same + 1;
		fprintf('%2.0f, ',y)
		
	end
end

	


