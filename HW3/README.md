## **Assignment Week 3: "Mini Social Network Application"**

### **Scenario:**

You are tasked with developing a **mini social network application**. In this application, users can:

* Create an account
* Add friends
* Share posts
* Like posts

### **Requirements:**

#### ✅ **User Class**

* Each user must have:

  * `username`
  * `email`
  * `age`

* A **nested class** called `Profile` must be included, containing:

  * `profilePicture`
  * `bio`

* All users should be stored in an `ArrayList`.

#### ✅ **Friends**

* Each user can add friends.
* Friends should be stored in a `HashSet` to avoid duplicate entries.

#### ✅ **Posts**

* Each user can share multiple posts.
* Posts should be stored in a `LinkedList`.
* Each post contains:

  * Post content
  * A `HashSet` of usernames who liked the post (to prevent duplicate likes)

#### ✅ **All Posts**

* Use a `HashMap` to track all posts:

  * `Key`: Username
  * `Value`: List of that user’s posts

#### ✅ **Popularity Ranking**

* Use a `TreeMap` or `TreeSet` to sort users based on the total number of likes received on their posts.
* Display the most popular user.

#### ✅ **Iterator Usage**

* Use an `Iterator` to list all users and their posts.

#### ✅ **Bonus (Optional)**

* Use **anonymous classes** or **lambda expressions** to filter data.
* Example bonus filters:

  * List users under 18 years old
  * Find posts containing a specific keyword
