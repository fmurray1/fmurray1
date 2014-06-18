function [td rh] = DewptRhum(T, Tw, BP)
% Input T = Dry-bulb temperature in degrees Celcius
% Input Tw = Wet-bulb temperature in degrees Celcius
% Input Bp = barometric pressure in MiliBars
% Output Td =Dewpoint temperature in degrees Celcius
% Output RH = relative humidity in percentage

es = 6.112*exp(17.67*T/(T+243.5));
ew = 6.112*exp(17.67*Tw/(Tw+243.5));
e = ew - BP*(T-Tw)*0.00066*(1+0.00115*Tw);

td = (243.5*log(e/6.112))/(17.67-log(e/6.112));
rh = 100*(e/es);

end