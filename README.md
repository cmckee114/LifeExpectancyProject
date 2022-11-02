# Exploring Factors Affecting Life Expectancies By State and Gender *Dataset Project*

---
## **Introduction**
---
### Topic Importance 
The reason I decided to research the topic of life expectancy is because because since I was 6 I have been volunteering for a shelter in Stamford called Inspirica which is a place where homeless and housing-insecure youth and families can live and go to rehab, become more financially literate, and eventually be placed in permanent housing. I've always been curious about how income can affect the quality and length of a person's life and how that varies around the US. We are fortunate to live in an area that focuses on the needs of others (like this shelter) probably partially due to the fact that we can financially contribute. When I was volunteering I would mainly attend Arts and Crafts and Reading nights with the children living in the shelter but when COVID hit, these programs were shut down and I knew Inspirica could use all the help it could get. Because of this, I founded a 501c3 organization called Heart to Art which raised over $150,000 last year for Inspirica and I hope to continue to combat this problem. I am really interested in this dataset because if life expectancy is affected by income level, how do we create a more equitable way of living/ how do we give those with lower income levels equal/similar access to the healthcare help they may need to live long, healthy lives? I'm also curious to see if there are regional differences or political differences by state and if that affects life expectancy- this is especially relevant because during COVID-19, data was collected that showed that there tended to be a significantly higher vaccination rate in democratic states over republican states and this data was published through many articles online like this one: [For Covid-19 Vaccination Rates, party affiliation matters more than race and ethnicity](https://www.brookings.edu/blog/fixgov/2021/10/01/for-covid-19-vaccinations-party-affiliation-matters-more-than-race-and-ethnicity/). This led me to be curious if this was true for other vaccines and if so, this affected the life expectancy of people in those states.

*To try to understand these topics I came up with two questions to try to solve:*
1. Do people in lower income quartiles tend to have lower life expectancies in the US?
2. Do the states of a certain political vote status (dem, rep, switch) have a generally higher life expectancy?

---
## **Methods**
---

### *Dataset -->* Describe what you know about how the data was generated. If possible, include information about who owns the dataset and why you are able to use it 

This dataset was created by Raj Chetty, Michael Stepner, Sarah Abraham and their other partners at JAMA Network republished by The Health Inequality Project. I have permission to use the dataset owner's dataset with the request that I cite their 2016 JAMA paper which they linked on The Health Inequality Project's website and has been viewed over 200,000 times and cited over 1,000 times. This is because the data was released to a public domain under a CC0 license to "permit the widest possible use." To get the dataset from its source visit this link [Health Inequality Project](https://healthinequality.org/data/). I used the third data file labeled "Satte life expectancy estimates" and edited it slightly just by deleting the first column of the data because I found it to be unneccessary and distracting from the data itself (it labeled the states 1-51 including the District of Columbia) I found by reading the overview topics of their paper that the data was generated in this manner:
 **"Income data for the US population were obtained from 1.4 billion deidentified tax records between 1999 and 2014. Mortality data were obtained from Social Security Administration death records. These data were used to estimate race- and ethnicity-adjusted life expectancy at 40 years of age by household income percentile, sex, and geographic area, and to evaluate factors associated with differences in life expectancy."**


### *Process -->* How did you go about answering your questions? What specific pieces of information did you need from your data set and how did you combine data to arrive at your answer?

To answer these questions, I first downloaded and created all of the datasets I thought I would need- this included LifeExpectancyData and then creating two smaller datasets called RedStates and BlueStates to holt the names of states that identified as "red" (republican) or "blue" (democrat). I did this so that if a state ever swung in another direction, someone could rerun my code by simply addding/removing a state from one dataset and adding/removing that same state to the other. I originally had the states directly in my code but wanted to make sure that someone who didn't know the ins and outs of coding in java would feel this was accessible and that they could simply rerun the same code with differences in data. To sort the states be party, I used the link below and the image below (within the article). Feel free to change the party affiliation for states and rerun my program to see how the life expectancies change!

[Which States Fall Under Which Party](https://www.governing.com/now/maps-whats-the-real-red-and-blue-balance-of-state-government)

Here is the map I used:
![Map](USMap.jpg)

To account for income quartile, I combined the life expectancies of everyone in the first income quartile, second, third, and foruth and compared the different averages to each other. All of this data came from the original LifeExpectancyData dataseta nd just involved me coding to access and manipulate each piece of data.

*For those interested in the technicalities of how I used code to solve the problems:*
For the IncomeQuartile method:
- I made a file and scanner to go through the LifeExpectancy dataset
- I created a header arraylist to be able to find the indexes of each of the values that I wanted to use to calculate the income quartile life expectancy differences (State name, Quartile 1 Female, Quartile 1 Male, Quartile 2 Female,...etc.)
- I went through each line in the LifeExpectancy dataset using a scanner and pulled the 8 life expectancies I needed per state in order to do my calculations (average of female and male data per quartile) + parsed the strings into doubles
- I added the average to its respective arraylist (Q1, Q2, Q3, or Q4) which held all of the averages for that quartile for all of the states
- Then, I averaged all averages within those arraylists (essentially combining all of the Q1 data from each of the states into one big Q1 average)
- Finally, I made a new ArrayList to hold the final 4 averages
- I created a max helper method to help me easily find the maximum average and printed out the results of my data

For the WinningParty method:
- I made files for the blueStates dataset and the lifeExpectancy dataset from the string addresses in the parameters (no need to redStates because the assumption is that if the state isn't in blue, it is in red)
- I created a header arraylist to be able to find the indexes of each of the values that I wanted to use to calculate the average life expectancy of that state (I needed Quartile 1 Female, Quartile 1 Male, Quartile 2 Female, Quartile 2 Male, Quartile 3 Female...etc and then averaged those 8 pieces of data)
- I went through each line of my data, averaging their life expectancy and then determining whether or not that state was in the blueStates dataset, which told me if it was a democrat leaning state or not
- To determine if a state was in the blueStates dataset I created a helper method that took the name of the state and the blueStates file and checked to see if the string was in the blueStates dataset and returned a boolean (true or false)
- Depending on whether or not it was democrat or republican, I added the average life expectancy of that state onto one of the arraylists (either blueStatesExpectancy or redStatesExpectancy)
- Finally, I looped through the arrayLists blueStatesExpectancy and redStatesExpectancy and averaged all of the averages in those respective arrays and stored those as final values for republican life expectancy and democrat life expectancy 
- I then printed the values I got 


### *Challenges -->* What difficulties did you run into, and how did you approach solving them?

I found that most of my challenges came in the form of not knowing what to expect for my results. For a while, I thought my returnWinningParty function was working correctly and it wasn't until I hand tested my babyData that I found an error in my coding. Without having hand calculated the averages for the babyData and realizing that the results were incorrect, I wouldn't have been able to find that my LifeExpectancy dataset results were also incorrect. Also,  before I developed a good checking system by incrementally testing my code I was getting 50-60 errors at a time. Once I started from my helper methods and systematically starting solving erros in my code, the errors began to decline but it took a while before I had this system down. Another error I ran into was making sure I had the correct parameters for each function. Technically, although I created a RedStates dataset, I only use the BlueStates dataset in my current code. This is because I assume that if a state is not on the BlueStates list that it must be on the RedStates list. Ideally, with more time I would not only double check that someone didn't accidentally remove a state from one list and forgets to add it to the other but I would also create a swing states dataset (one that would have the purple states, or states that tend to switch) to test whether or not the difference in life Expectancy is more drastic between red and blue states having removed the swing states. The only reason I did not incorperate this in my current data is because according to the sources I looked up, swing states can be pretty subjective and I didn't want to mess up the data calculations based on my own personal biases. 

---
## **Results and conclusion**
---

### What did the data show? What are your takeaways? Plots might be helpful (though not required) depending on your question. Make sure to also discuss the limitations of your research.

In the test regarding the difference in life expectancy by party (republican states vs democratic states), my hypothesis was correct in that the average life expectancy was higher for democrat leaning states. The results came out to be ~83.161 for democratic states and ~82.96 for republican states. Although these reuslts technically support my hypothesis, because of how minute the difference is, I don't eblieve I can draw a strong correlation to the political status of states being a drastically influential factor in the life expectancy of people living in those states. 

In the test regarding the effect of income quartile on life expectancy, the correlation was much stronger and supported my hypothesis quite well. The first income quartile average life expectancy was ~79.132, the second was ~82.288, the third was ~84.330, and the fourth was ~86.429. Unlike the miniscule difference in life expectancy in the last problem, in this test the difference is quite clear. As income level rises, the life expectancy of people also rises. I may not be able to prove correlatino yet because of the confounding factors present that I may not be accounting for, but seeing this trend was exciting.


### Additional thoughts/questions i'm interested in:

If I had more time and resources I would explore the differences in male and female results and probably also go into more depth by state (i.e. adding a dataset for swing states (ones that often switch between republican and democrat majorities))

The questions I would probably pose might look something like the following:
If I removed swing states from the data, would the results be more drastic? 
At what point is the difference in life expectancies by party status correlation?

I would also like to know how my data for income quartile changes if I weight the states based on population size (obviously California is going to have more weight than Kansas because it has many more people in the state) and there was actually data columns in my LifeExpectancyData file that contained the population of each state (which has probably also changed since the dataset has been uploaded)

