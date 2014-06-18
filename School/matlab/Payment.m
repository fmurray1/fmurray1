% P = premium
% r = interest rate
% y = # of years for loan
% yV = range of years from 10 tp 30 incrementing by 1
% M = monthly Payment
% tot = total payments listed from 10 - 30 years



P = 100000;
r = 0.0485;
y = 30;
yV = [10:30]

M = (P *( r/12))/ (1 - (1 +r/12)^(12*y))

tot = [M .* yV]



%table = [yV', ones(1,21)*M, tot']


