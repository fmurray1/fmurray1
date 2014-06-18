%Know Variables%
patrons=6583;
%Gumball Variables%
dsmall=(5/8);
dmedium=(1+1/8);
dlarge=(1+3/4);
cost_small=.03;
cost_medium=.07;
cost_large=.16;
price_small=.05;
price_medium=.10;
price_large=.25;
vsmall=(4/3)*pi*(dsmall*.5)^3;
vmedium=(4/3)*pi*(dmedium*.5)^3;
vlarge=(4/3)*pi*(dlarge*.5)^3;
s_ratio=9/350;
m_ratio=5/350;
l_ratio=2/350;
sold_small=fix(s_ratio*patrons);
sold_medium=fix(m_ratio*patrons);
sold_large=fix(l_ratio*patrons);
%machine variables%
volume_cube=10*10*10;
volume_rhombus=11*11*14;
volume_sphere=(4/3)*pi*5^3;
ratio=.78;
cube=volume_cube*ratio;
rhombus=volume_rhombus*ratio;
sphere=volume_sphere*ratio;
cost_cube=325;
cost_rhombus=350;
cost_sphere=300;
fill_cost=5;

%Calculations for Amount of Gumballs %
gs_cube=fix(cube/vsmall);
gs_rhombus=fix(rhombus/vsmall);
gs_sphere=fix(sphere/vsmall);

gm_cube=fix(cube/vmedium);
gm_rhombus=fix(rhombus/vmedium);
gm_sphere=fix(sphere/vmedium);

gl_cube=fix(cube/vlarge);
gl_rhombus=fix(rhombus/vlarge);
gl_sphere=fix(sphere/vlarge);

%Calculations for amount of gumballs when machine needs refilled%
refill_scube=fix(gs_cube*.25);
refill_srhombus=fix(gs_rhombus*.25);
refill_ssphere=fix(gs_sphere*.25);

refill_mcube=fix(gm_cube*.25);
refill_mrhombus=fix(gm_rhombus*.25);
refill_msphere=fix(gm_sphere*.25);

refill_lcube=fix(gl_cube*.25);
refill_lrhombus=fix(gl_rhombus*.25);
refill_lsphere=fix(gl_sphere*.25);

%Calculations for difference between Max and Min number of Gumballs%
available_scube=gs_cube-refill_scube;
available_srhombus=gs_rhombus-refill_srhombus;
available_ssphere=gs_sphere-refill_ssphere;

available_mcube=gm_cube-refill_mcube;
available_mrhombus=gm_rhombus-refill_mrhombus;
available_msphere=gm_sphere-refill_msphere;

available_lcube=gl_cube-refill_lcube;
available_lrhombus=gl_rhombus-refill_lrhombus;
available_lsphere=gl_sphere-refill_lsphere;

%Calculations for days to till refill, is rounded up based that on the
%assumption that gumballs will still be sold when amount of gumballs dips
%below .25 of max number of gumballs, and refilled at the beginning of the
%next day
days_scube=ceil(available_scube/sold_small);
days_srhombus=ceil(available_srhombus/sold_small);
days_ssphere=ceil(available_ssphere/sold_small);

days_mcube=ceil(available_mcube/sold_medium);
days_mrhombus=ceil(available_mrhombus/sold_medium);
days_msphere=ceil(available_msphere/sold_medium);

days_lcube=ceil(available_lcube/sold_large);
days_lrhombus=ceil(available_lrhombus/sold_large);
days_lsphere=ceil(available_lsphere/sold_large);

%Calculations for Periods in Year%
periods_scube=365/days_scube;
periods_srhombus=365/days_srhombus;
periods_ssphere=365/days_ssphere;

periods_mcube=365/days_mcube;
periods_mrhombus=365/days_mrhombus;
periods_msphere=365/days_msphere;

periods_lcube=365/days_lcube;
periods_lrhombus=365/days_lrhombus;
periods_lsphere=365/days_lsphere;


%Calculations for gumballs sold until refill%
gsold_scube=days_scube*sold_small;
gsold_srhombus=days_srhombus*sold_small;
gsold_ssphere=days_ssphere*sold_small;

gsold_mcube=days_mcube*sold_medium;
gsold_mrhombus=days_mrhombus*sold_medium;
gsold_msphere=days_msphere*sold_medium;

gsold_lcube=days_lcube*sold_large;
gsold_lrhombus=days_lrhombus*sold_large;
gsold_lsphere=days_lsphere*sold_large;

format bank
%Profit Year One%
profit_year1_scube=gsold_scube*periods_scube*price_small;
profit_year1_srhombus=gsold_srhombus*periods_srhombus*price_small;
profit_year1_ssphere=gsold_ssphere*periods_ssphere*price_small;

profit_year1_mcube=gsold_mcube*periods_mcube*price_medium;
profit_year1_mrhombus=gsold_mrhombus*periods_mrhombus*price_medium;
profit_year1_msphere=gsold_msphere*periods_msphere*price_medium;

profit_year1_lcube=gsold_lcube*periods_lcube*price_large;
profit_year1_lrhombus=gsold_lrhombus*periods_lrhombus*price_large;
profit_year1_lsphere=gsold_lsphere*periods_lsphere*price_large;

%Expenses Year One%
expenses_year1_scube=cost_cube+fix(periods_scube)*gsold_scube*cost_small+gs_cube*cost_small+fix(periods_scube)*fill_cost;
expenses_year1_srhombus=cost_rhombus+fix(periods_srhombus)*gsold_srhombus*cost_small+gs_rhombus*cost_small+fix(periods_srhombus)*fill_cost;
expenses_year1_ssphere=cost_sphere+fix(periods_ssphere)*gsold_ssphere*cost_small+gs_sphere*cost_small+fix(periods_ssphere)*fill_cost;

expenses_year1_mcube=cost_cube+fix(periods_mcube)*gsold_mcube*cost_medium+gm_cube*cost_medium+fix(periods_mcube)*fill_cost;
expenses_year1_mrhombus=cost_rhombus+fix(periods_mrhombus)*gsold_mrhombus*cost_medium+gm_rhombus*cost_medium+fix(periods_mrhombus)*fill_cost;
expenses_year1_msphere=cost_sphere+fix(periods_msphere)*gsold_msphere*cost_medium+gm_sphere*cost_medium+fix(periods_msphere)*fill_cost;

expenses_year1_lcube=cost_cube+fix(periods_lcube)*gsold_lcube*cost_large+gl_cube*cost_large+fix(periods_lcube)*fill_cost;
expenses_year1_lrhombus=cost_rhombus+fix(periods_lrhombus)*gsold_lrhombus*cost_large+gl_rhombus*cost_large+fix(periods_lcube)*fill_cost;
expenses_year1_lsphere=cost_sphere+fix(periods_lsphere)*gsold_lsphere*cost_large+gl_sphere*cost_large+fix(periods_lsphere)*fill_cost;


%Net Profit Year One%
netprofit_year1_scube=profit_year1_scube-expenses_year1_scube;
netprofit_year1_srhombus=profit_year1_srhombus-expenses_year1_srhombus;
netprofit_year1_ssphere=profit_year1_ssphere-expenses_year1_ssphere;

netprofit_year1_mcube=profit_year1_mcube-expenses_year1_mcube;
netprofit_year1_mrhombus=profit_year1_mrhombus-expenses_year1_mrhombus;
netprofit_year1_msphere=profit_year1_msphere-expenses_year1_msphere;

netprofit_year1_lcube=profit_year1_lcube-expenses_year1_lcube;
netprofit_year1_lrhombus=profit_year1_lrhombus-expenses_year1_lrhombus;
netprofit_year1_lsphere=profit_year1_lsphere-expenses_year1_lsphere;

%Expenses for Year 2%
expenses_year2_scube=fix(periods_scube)*gsold_scube*cost_small+fix(periods_scube)*fill_cost;
expenses_year2_srhombus=fix(periods_srhombus)*gsold_srhombus*cost_small+fix(periods_srhombus)*fill_cost;
expenses_year2_ssphere=fix(periods_ssphere)*gsold_ssphere*cost_small+fix(periods_ssphere)*fill_cost;

expenses_year2_mcube=fix(periods_mcube)*gsold_mcube*cost_medium+fix(periods_mcube)*fill_cost;
expenses_year2_mrhombus=fix(periods_mrhombus)*gsold_mrhombus*cost_medium+fix(periods_mrhombus)*fill_cost;
expenses_year2_msphere=fix(periods_msphere)*gsold_msphere*cost_medium+fix(periods_msphere)*fill_cost;

expenses_year2_lcube=fix(periods_lcube)*gsold_lcube*cost_large+fix(periods_lcube)*fill_cost;
expenses_year2_lrhombus=fix(periods_lrhombus)*gsold_lrhombus*cost_large+fix(periods_lrhombus)*fill_cost;
expenses_year2_lsphere=fix(periods_lsphere)*gsold_lsphere*cost_large+fix(periods_lsphere)*fill_cost;

%Net Profit Year Two%
netprofit_year2_scube=netprofit_year1_scube+profit_year1_scube-expenses_year2_scube;
netprofit_year2_srhombus=netprofit_year1_srhombus+profit_year1_srhombus-expenses_year2_srhombus;
netprofit_year2_ssphere=netprofit_year1_ssphere+profit_year1_ssphere-expenses_year2_ssphere;

netprofit_year2_mcube=netprofit_year1_mcube+profit_year1_mcube-expenses_year2_mcube;
netprofit_year2_mrhombus=netprofit_year1_mrhombus+profit_year1_mrhombus-expenses_year2_mrhombus;
netprofit_year2_msphere=netprofit_year1_msphere+profit_year1_msphere-expenses_year2_msphere;

netprofit_year2_lcube=netprofit_year1_lcube+profit_year1_lcube-expenses_year2_lcube;
netprofit_year2_lrhombus=netprofit_year1_lrhombus+profit_year1_lrhombus-expenses_year2_lrhombus;
netprofit_year2_lsphere=netprofit_year1_lsphere+profit_year1_lsphere-expenses_year2_lrhombus;

figure
x=[netprofit_year1_scube netprofit_year1_srhombus netprofit_year1_ssphere netprofit_year1_mcube netprofit_year1_mrhombus netprofit_year1_msphere netprofit_year1_lcube netprofit_year1_lrhombus netprofit_year1_lsphere]
pie(x)

figure
bar(1:9,x)

