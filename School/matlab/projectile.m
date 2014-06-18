t = [0:.1:8];
p = [0.41 .* t.^4 - 10.8 .* t.^3 + 64 .* t.^2 - 8.2 .* t + 4.4];
v = [1.64 .* t.^3 - 32.4 .* t.^2 + 128 .* t - 8.2];
a = [4.92 .* t.^2 - 64.8 .* t + 128];

subplot(3,1,1)
plot(p,t)
subplot(3,1,2)
plot(v,t)
subplot(3,1,3)
plot(a,t)