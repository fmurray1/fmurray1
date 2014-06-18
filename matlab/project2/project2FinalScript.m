% Case 1

[aS1 aB1 BAC1] = bacCalc(70, 0.68, 3, 2, 900, 0, 0, 0.015);

for i=120:900

	if BAC1(i) < 0.08
		time1 = ((i-120)/60);
		break
	end
end

fprintf('The 70 kg grad student who drank 6 beers in 2 hours\n would have to wait %f hours after he stopped drinking before driving\n', time1)


% Case 2

maxBAC1 = max(BAC1);

% Person 1


[aS21 aB21 BAC21] = bacCalc(45.4, 0.68, 3, 2, 900, 0, 0, 0.015);

maxBAC2_1 = max(BAC21);

figure

for j=120:900

	if BAC21(j) < 0.08
		time2_1 = ((j-120)/60);
		break
	end
end


timeDif1 = time1 - time2_1;


fprintf('The 45.4 kg grad student would have to wait %f hours before driving which is %f hours longer than the 70kg student\n', time2_1, timeDif1)

% Person 3

[aS2_3 aB2_3 BAC2_3] = bacCalc(90.7, 0.68, 3, 2, 900, 0, 0, 0.015);

maxBAC2_3 = max(BAC2_3);



for l=120:900

	if BAC2_3(l) < 0.08
		time2_3 = ((l-120)/60);
		break
	end
end

timeDif2 = time2_3 - time1;

fprintf('The 90.7 kg grad student would have to wait %f hours before driving which is %f hours less than the 70kg student\n', time2_3, timeDif1)

plot([1:900], BAC1, [1:900], BAC21, [1:900], BAC2_3)
xlabel('Time (min)')
ylabel('Blood Alcohol Concentration (g/dL)')
title('Case 2 BAC vs Time')
legend('70kg Student', '45.4 kg Student', '90.7 kg Student')


fprintf('The max BAC for the 70 kg Student is: %f\n', maxBAC1)
fprintf('The max BAC for the 45.4 kg Student is: %f\n', maxBAC2_1)
fprintf('The max BAC for the 90.7 kg Student is: %f\n', maxBAC2_3)


% Case 3

% Man

[aS3_M aB3_M BAC3_M] = bacCalc(60, 0.68, 3, 2, 900, 0, 0, 0.015);

maxBAC3_M = max(BAC3_M);

for m=120:900

	if BAC3_M(m) < 0.08
		time3_M = ((m-120)/60);
		break
	end
end

% Woman

[aS3_W aB3_W BAC3_W] = bacCalc(60, 0.55, 3, 2, 900, 0, 0, 0.015);

maxBAC3_W = max(BAC3_W);

for n=120:900

	if BAC3_W(n) < 0.08
		time3_W = ((n-120)/60);
		break
	end
end

figure

plot([1:900], BAC3_M, [1:900], BAC3_W)
xlabel('Time (min)')
ylabel('Blood Alcohol Concentration (g/dL)')
legend('60 kg Man', '60 kg Woman')
title('Case 3 60 kg Man vs 60 kg Woman')

fprintf('The max BAC for the 60 kg man is: %f\n', maxBAC3_M)
fprintf('The max BAC for the 60 kg woman is: %f\n', maxBAC3_W)

fprintf('The man has to wait %f hours after he has stopped drinking before he can drive\n', time3_M)
fprintf('The woman has to wait %f hours after she has stopped drinking before she can drive\n', time3_W)


% Case 4

[aS4_1 aB4_1 BAC4_1] = bacCalc(70, 0.68, 3, 2, 180, 0, 0, 0.015);

[aS4_2 aB4_2 BAC4_2] = bacCalc(70, 0.68, 3, 1, 900, aS4_1(180), aB4_1(180), 0.015);

aS4tot = [aS4_1, aS4_2];
aB4tot = [aB4_1, aB4_2];
BAC4tot = [BAC4_1, BAC4_2];

fprintf('The BAC of the student who drank 9 bees after he finished his last beer is: %f\n', BAC4_2(240))

maxBAC4 = max(BAC4tot); 

fprintf('His max BAC was: %f', maxBAC4)

for o=120:900

	if BAC4_2(o) < 0.08
		time4 = ((o-120)/60);
		break
	end
end

fprintf('He has to wait %f hours before he can legally drive\n', time4)

subplot(2,1,1)

plot([1:1080], aS4tot, [1:1080], aB4tot)
xlabel('Time (min)')
ylabel('Alcohol (g)')
title('Case 4 Alcohol in System')
legend('In Stomach', 'In Body')


subplot(2,1,2)

plot([1:1080], BAC4tot)
xlabel('Time (min)')
ylabel('Blood Alcohol Concentration (g/dL)')
title('Case 4 BAC vs Time')



% Case 5


[aS5 aB5 BAC5] = bacCalc(70, 0.68, 3, 2, 900, 0, 0, 0.03);

plot([1:900], BAC1, [1:900], BAC5)
xlabel('Time (min)')
ylabel('Blood Alcohol Concentration (g/dL)')
title('Case 5 Alcoholic Compared to Moderate Drinker')
legend('Moderate Drinker', 'Alcoholic')


