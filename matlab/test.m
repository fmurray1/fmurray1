i = 0;
a='hi';
while (i < 500000)
  if (i == 450000)
    disp(a);
    i=0;
  end
  i= i+1;
end 
