function mps = mphTOmets(mph)
% input miles per hour = mph
% return meters per second = mps
% 1 mile = 1609.34 meters
% 1 hour = 3600 seconds


miTOm = 1609.34;
hTOs = 3600;

mps = mph * miTOm / hTOs;

end
