What are the key and value types? Why is the name useful as a key?
The key is the name of the Pokemon in this case and the Value is the object itself. The name is useful as a key because we can hash the name and modulate it by the length of the table to decide what bucket to refer to the object. 

Using the provided hash() method and % 11, show the bucket calculation for two names that collided. Must their full hash codes match?
When two names collide in a bucket calculation then the bucket will create an array within that bucket to link each object to another within that buck. Their full hash does not need to match, if it matches after modulation then that causes the collision in which we can do a few things with like creating an array/linked list within each bucket with collisions. 

Trace how get() finds the second name in that chain. What causes it to stop?
Get() finds the second name by first hashing the name that it has been given and follows the bucket down until it find the name it is designated in. However, if the bucket reaches the end and returns null then this means the name is not in the table.

Why does insert() update an existing key instead of adding a duplicate? What changes when remove() deletes the first node?
First the code will see if there is already an existing key by looking to see if the name is the same within the buckets list after hashing. If it finds the name then all it needs to do it only update the value (object) within it. When deleting the first node the bucket then points to the second node (object) as the new first node to be shown in the bucket.

What happens to lookup work when many names land in one bucket?
What happens is the program will go through the chain and search one node at a time to see it that key matches with the key put in as a parameter. 

How does Pokemon.equals() differ from ==? Why does Pokemon need a matching hashCode(), and which class's hashCode() does this table use for its keys?
Pokemon.equals() will compare the Pokemon objects to one another and see if they are the same while == just checks if the memory address is the same. 
Pokemon need a matching hashcode() because if the pokemon object is equal to each other then the hashcode also has to be too since both of these methods used @Override to adjust how they work. This helps to make sure that if there is already an object with the same name or key then we can just update it or do something else with it.
The class's hashCode() the table uses for its keys are Pokemon objects. for example mew.hashCode();
