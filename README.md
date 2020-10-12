# Overview
    - price module for calculating price of Cycle based on its parts
    
#Input
    - Cycles intput data is taken from input.json file which will be converted into 'Product' Object
    - Price data is initialise from priceData.json file, 
        - later price of a part can be changed through updatePrice Method of PriceService Class
#Output
    - printing Total price of a cycle and also price for each high level component - frame, wheels etc together.
    
# Service Components
    - Application : start point of this module
    - Producer : taking cycle input data and dumping into blockingQueue
    - Consumer : consuming object(Product) from blockingQueue and calculating its price
    - PriceService : to calculate price of a cycle and also update price of a part of cycle
    
# In-memory DS
    - Map<String, TreeMap<Date,Double>> priceMap : to storing price of every parts of the cycle
        - key will be unique Id(String) like for tyre, it will be "wheels.tyre"
        - value will be TreeMap 
            - key will be date when price was/will be updated
            - value will be price according to the date
    - ArrayBlockingQueue : to storing input of cycle object
    
# Functionality
    - Every Component of Cycle contain getPrice method which will calculate price of its children parts
    - to get a price of a part of the cycle for a particular date, priceMap will be used and floorKey() of the given date in the treeMap will be considered
      