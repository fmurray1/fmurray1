A = 11;
B = 18;
C = 26;
D = 9;
F = 2;


bar([A,B,C,D,F])
set(gca, 'XTick', 1:5, 'xticklabel', {'A', 'B', 'C', 'D', 'F'})
xlabel('Grades')
ylabel('Number of each Grade')
title('Engineering First Test Results')

