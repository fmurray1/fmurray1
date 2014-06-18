function [aStomach, aBody, bac] = bacCalc(weight, percentLiquid, drinksPerHr, hrsDrink, minSim, alcoholStomach, alcoholBody, Vmax)

liquidWeight = weight * percentLiquid * 10; % takes the wight in kg and converts it to dL
iR = (drinksPerHr * 13.6)/60; % intake Rate (g/min)
timeDrink = 60 * hrsDrink; % number of minutes spent drinking
aStomach = [alcoholStomach];
aBody = [alcoholBody];
elimAmt = 0;
bac = [(alcoholBody/liquidWeight)];
Km = 0.01;





for i=2:(minSim)
		
		if i <= timeDrink
		
        	aStomach = [aStomach, (aStomach(i-1) - aBody(i-1) + iR)]; %takes the current vector of the amount of alcohol in the stomach then updates it to have the new amount as the next value stored
        else
        	aStomach = [aStomach, (aStomach(i-1) - aBody(i-1))];
        end
        
        aBody = [aBody, (aBody(i-1) - elimAmt + (aStomach(i-1) * 0.0693))]; %takes the current vector of the amount of alcohol in the body then updates it to have the new amount as the next value stored
        bac = [bac, (aBody(i)/liquidWeight)]; %takes the current vector of the BAC then updates it to have the new amount as the next value stored
        elimRate = (bac(i) * Vmax)/(Km + bac(i)); % uses the last updated bac value to calculate teh elimination rate
        elimAmt = elimRate * liquidWeight; %uses the current elimination rate to get the elimination amount
end

%for j=1:(minSim)
%    
 %   if aStomach(i)<0
        
 %       aStomach(i) = 0;
%    end
    
 %   if aBody(i)<0
%        
%        abody(i) = 0;
%    end
    
%    if bac(i)<0
        
 %       bac(i) = 0;
 %   end
    
% end

end
    
    
    
    