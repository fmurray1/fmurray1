function BFP = Body_Fat(w,h,age,gen) %1 = male 0 = female
% Input w = weight
% input h = height in inches
% input age = age
% input gen = gender: 1 = male 0 = female
% output BFP = body fat percentage

BMI = 703 * w /h^2;
BFP = 1.2*BMI +0.23*age - 10.8*gen - 0.54;
end
