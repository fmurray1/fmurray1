w = input('please enter your weight in pounds: ');
h = input('please enter your height in inches: ');

bmi = 703 * (w/h^2);

bmi = roundn(bmi, -1);

if bmi < 18.5
	
	fprintf('Your BMI value is %2.1f which classifies you as underweight\n', bmi)
	
elseif bmi >= 18.5 & bmi <= 24.9

	fprintf('Your BMI value is %2.1f which classifies you as normal\n', bmi)
	
elseif bmi >= 25 & bmi <= 29.9

	fprintf('Your BMI value is %2.1f which classifies you as overweight\n', bmi)
	
elseif bmi >= 30

	fprintf('Your BMI value is %2.1f which classifies you as obese\n', bmi)
	
else

	fprintf('There was an error in your submission\n')
	
end

