# hotels.com


Given Requirement:
simple application that prints out the details of a receipt containing items purchased by a customer. The receipt should list the number of items, the name, the final price (including taxes) of each of the item purchased, plus two extra lines showing the total amount of the receipt and the total amount of taxes.

Taxes are calculated with a rate of 20%. Please note that medical products are exempt, i.e. 0%.


Notes: 
Please note that input/output or persistency are NOT required.
don’t focus on dynamic inputs, string parsing, and inventory management etc., And don’t develop a web application.
----------------------------------------------------------------------------------------------------------------
Scope:

Extending functionality for customer's further/untold requirements

Given falt tax rate of 20%, but it is obvious customer will need multiple tax % for different items.
can create multiple category, item, taxes
data feed in memory through starup load
[Scalable]entity relations mapping done on startup load in memory
	- item & category association
	- item, tax association
	- category, tax association
Tables represented in Map manner
[Configurable]configurable application
	- load from properties, no need of code change for feature toggel.
Tax breakup functlity
tax overriding functionality
discount functionality
choice of tax functionality
	- highest, lowest
	- category tax, item tax
choice of Packing functionality
Rule execution
	- item specific rule execution
	- Category specific rule execution
[Extendable]Any new type of category, tax, item can be easily plugin with minimal changes in factory only  
Enhanced Output

Not in scope:
User interaction with I/O
Nested category
Logger
Inventory

Design Pattern:
Abstract Factory
Builder
Filter
Composit Object


Disclaimer: 
Tax is based on assumptions & my understanding.

Need to recheck on given output 
Input: 
1 pen: 5
Output: 
Error message