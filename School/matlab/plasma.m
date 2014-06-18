A = 140;
Kab = 1.6;
Kel = 0.45;
t = [0:.25:10];

Cp = [A*(Kab/(Kab-Kel)*(exp(-Kel.*t)-exp(-Kab.*t)))];

plot(t, Cp)
xlabel('Time (h)')
ylabel('Plasma Concentration (mg/L)')
title('Plasma Concentration over time')