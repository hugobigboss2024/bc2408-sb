	Yahoo Finance OpenAPI
	Yahoo Finance provides lots of finance market data in different kinds of format, such as web APIs, CSV
	download, etc. In this exercise, let's try to develop APIs to get the data source from Yahoo Finance APIs and
	store them as our own data, and then we can provide our own unique services to customers.
	This is a page from Yahoo Finance showing the historical quote data, which allows users to download the
	stock quote data in CSV format. Also, you can provide a timeframe to download the corresponding quote
	data between a date range. (https://finance.yahoo.com/quote/0388.HK/history)
    	Apart from CSV download for historical quote data, web APIs are provided for web systems interaction.
	Here are some examples:
	https://query1.finance.yahoo.com/v7/finance/quote?symbols=0388.HK
	However, you will find an exception if you do not provide the necessary crumb key, the authentication key for
	accessing the web service.
    	So, your Spring Boot application should get the crumb key before calling YH Finance API
	The way to get the crumb key by another API call.
	GET: https://query1.finance.yahoo.com/v1/test/getcrumb
    	Before calling API (getting quote data), you should add the crumb key as a request parameter.
	GET: https://query1.finance.yahoo.com/v7/finance/quote?symbols=0388.HK&crumb=nklxXSQfYy
    	Your Tasks
	Task 1 - Backend Service For YH Finance
	Create a spring boot project bc-yahoo-finance with appropriate maven dependencies.
	Task 2 - CommandLine Runner
	Develop a CommandLine Runner to load a list of stock symbols (i.e. 0388.HK, 0700.HK) to a Database
	table. For example, hardcode some of the stock symbols in the class, "0388.HK", "0700.HK", etc.
    	Task 3 - Get Stock List (Cache Pattern)
	If the list of stock symbols is available in Redis, return them directly; otherwise, read them from database
	and refresh them back to Redis, with expiry in 24 hours.
	Create CommandLineRunner to clear the Redis entry during server start process.
	Think about the design and structure of the symbol list being stored in Redis.
	Sample entry in Redis (for stock list)

	  1 {"STOCK-LIST" : ["0388.HK", "0700.HK"]}
	  
    	Task 4 - Scheduler For Extract and Load
	Create a scheduler (every 5 minutes, i.e. 10:00:05:005:005:00, etc.) in order to get stock quote data, based
	on the list of symbols stored in Redis/Table (developed in Task 3) and then store the quote data in table
	TSTOCK_QUOTE_YAHOO.
	Sample YH quote OpenAPI.
	GET: https://query1.finance.yahoo.com/v7/finance/quote?symbols=0388.HK&crumb=nklxXSQfYyr
	Store the required JSON data from Yahoo API.
	symbol
	regularMarketUnix (real market time in Unix timestamp)
	regularMarketPrice
	regularMarketChangePercent
	bid
	bidSize
	ask
	askSize
	Design the table TSTOCK_QUOTE_YAHOO and implement it by JP/&Entity. Besides the above fields from
	YH API, please add the fields below.
	TYPE (5M = 5 Minutes, Daily, W= Weekly, M= Monthly)
	API Datetime (current time stamp)
	Market Time in normal timestamp (converted from regularMarketUnix in JSON)
    	Task 5 - API Design (Reading)
	Now, we are going to develop an API to provide the 5-min data set trading day. Before the trading day. Before
	moving to task 5(Solution), let's understand the scenario in this part.
	Scenario 1: During the timeframe on the trade date, this API should return all the 5-min data being
	stored in database/redis
	(Examples: At 08:55, before the market opens, the API should return the set of 5-min data of the
	last trade day; after 09:00, after the market opens, the API should return the 5-min data for that
	date only).
	Scenario 2: During the holiday, the API should return a full set of 5-min data on the last trade date.
	The idea is similar to the following SQL (PostgreSQL syntax).
	Think about system design (Redis, DB & Scheduler) that is able to achieve the same
	purpose.
    	Task 6 - API Development
	Task 6a - GET System Date (Cache Pattern)
	Retrieve system date from Redis by stock symbol
	If it is found, return the date value as System Date.
	TSTOCK_QUOTE_YAHOO and
	If it is not found, get max. of regular_market_time in YYY-MM-DD from
	then update the entry in Redis (expiry 4 hours).
	Create a scheduler to clear all system date Redis entries at 08:55 a.m. every day.
	Create commandLineRunner to clear all system date Redis entries during server start process.
	Sample entry of SYSDATE in Redis
    	Task 6b - API for 5-min Data (Cache Pattern)
	Develop API to return the list of 5-min data on the system date...
	Get 5-min Quote Data
	If the Redis entry is not found, retrieve it from the Database table by System date and then
	create the entry in Redis, with the list of 5-min data, if any. (expiry 12 hours)
	Sample Redis Entry & the 5-min list (Key: "5MIN-0388.HK")
    	Or if the Redis entry (5-min data) is found:
	Then retrieve the max regularMarketTime from database on System date
	If DB regularMarketTime is not found, return empty 5-min data list.
	If DB regularMarketTime is found, and if DB regularMarketTime > Redis
	regularMarketTime, replace the list to Redis entry.
	Otherwise, return the Redis entry
