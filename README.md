# Cigarette Smokers Problem

Assume a cigarette requires three ingredients to make and smoke: tobacco, paper, and matches. There are three smokers around a table, each of whom has an infinite supply of one of the three ingredients — one smoker has an infinite supply of tobacco, another has paper, and the third has matches.

There is also a non-smoking agent who enables the smokers to make their cigarettes by arbitrarily (non-deterministically) selecting two of the supplies to place on the table. The smoker who has the third supply should remove the two items from the table, using them (along with their own supply) to make a cigarette, which they smoke for a while. Once the smoker has finished his cigarette, the agent places two new random items on the table. This process continues forever. 
([Description source](https://www.wikiwand.com/en/Cigarette_smokers_problem "Cigarette Smokers Problem"))


**class Smoker** - class that implements smoker, have two fields: name and ingredient that smoker own.

**class NonSmokingAgent** - class that implements mechanism that selects two random ingredients ant places it on table.
