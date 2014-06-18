fprintf('This program will calculate your training heart rate\n')

gen = input('Are you male or female? ', 's');

age = input('What is your age? ');

rhr = input('What is your resting heart rate? ');

inten = input('What is the intensity of your work out? (Low, medium, or high) ', 's');

gen = lower(gen);

inten = lower(inten);

if strcmp(gen,'male')

	if strcmp(inten,'low')
		
			thr = ((220-age)-rhr)*0.55+rhr;
			fprintf('Your training heart rate is: %3.0f\n', thr)
			
	elseif strcmp(inten,'medium')
	
			thr = ((220-age)-rhr)*0.65+rhr;
			fprintf('Your training heart rate is: %3.0f\n', thr)
			
	elseif strcmp(inten,'high')
	
			thr = ((220-age)-rhr)*0.8+rhr;
			fprintf('Your training heart rate is: %3.0f\n', thr)
			
	else
	
			fprintf('There was an error with your submission.')
	end

elseif  strcmp(gen,'female')

	if strcmp(inten,'low')
		
			thr = ((206-0.88*age)-rhr)*0.55+rhr;
			fprintf('Your training heart rate is: %3.0f\n', thr)
			
	elseif strcmp(inten,'medium')
	
			thr = ((206-0.88*age)-rhr)*0.65+rhr;
			fprintf('Your training heart rate is: %3.0f\n', thr)
			
	elseif strcmp(inten,'high')
	
			thr = ((206-0.88*age)-rhr)*0.8+rhr;
			fprintf('Your training heart rate is: %3.0f\n', thr)
			
	else
	
			fprintf('There was an error with your submission.')
	end		
else

	fprintf('There was an error in your submission')
end