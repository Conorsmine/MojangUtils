# MojangUtils
*MojangUtils* is a utility library for the popular [NBTAPI](https://github.com/tr7zw/Item-NBT-API).  
*MojangUtils* mainly focuses on the implementation of `NBTPath`s.  

## Usage
You can freely download, share, alter and ofcourse use this code.  
Too use or "import" the project, download the source code and add it to your project. Though refactoring of the import is probably needed then.  
However, this code is not "multi-version" compatible, yet (?). So manier import will probably not be functioning anyways and some alterations might need to be made.

## MojangsonUtils
The `MojangsonUtils` class has 3 main functionalities:
- *Formatting*; Format `NBT` extensively with the `#getInteractiveMojangson` method
- *Getting*; Retrieving data via the `#getDataFromPath` method
- *Setting*; Setting data into `NBT` via the `<T> #setDataToPath` method

Too create an instance of `MojangsonUtils` use the `MojangsonUtilsBuilder` too create an instance with the formatting you desire.

## NBTPath
`NBTPath`s are meant to allow the traversal of `NBT` with text! This is especially useful if you want users to be able to input and work with `NBT`.  
`NBTPath`s are therefore just a collection of `NBTKey`s with a certain string value.  
Too create a `NBTPath` create a `NBTPathBuilder` first and add all neccessery keys to it, before ceating the actual `NBTPath`.  
This is done to ensure that `NBTPaths` don't change after being created.

### NBTKey  
There are 2 types of `NBTKey`s:  
- `NBTKey`; A string key for key-value pairs/`NBTCompound`s
- `NBTArrayKey`; A integer key for lists or arrays

Creating either can be done with their respective `#parseStringToKey` function.

## Code Examples
Since `MojangsonUtils` is the main aspect of the code library, let's start there:
```
final MojangsonUtils utils = new MojangsonUtilsBuilder("##")
                .setValCol(ChatColor.RED)
                .setValTypeCol(ChatColor.MAGIC)
                .setTagCol(ChatColor.AQUA)
                .create();
```
Here we create an instance of `MojansonUtils` where the `Separator` is "##". This means that `NBTPathBuilder`s using this instance will split the provided String at every instance of "##".  

```
final NBTPath baublesPath = new NBTPathBuilder(utils).parseString("ForgeCaps##baubles:container##Items").create();
```
Here `utils` is a the instance of the `MojangsonUtils` class from above.  
The `#praseString` method will split the provided String at every "##", resulting in the following path:  
`ForgeCaps -> baubles:container -> Items`  

But how do `NBTArrayKey`s work? Very simply:
```
final NBTArrayKey arrKey = NBTArrayKey.parseToArrayKey(0);
```  
This creates in secret a regular `NBTKey` with a key value of "[0]". The same formatting can be used when parsing a String to `NBTPathBuilder`:  
```
final NBTPath arrKey = new NBTPathBuilder(utils).parseString("[0]").create();
```  
Both do practically the same, but one is alot easier todo and recommended.  

In case you want to create an empty `NBTPath` you can do it the following:
```
final NBTPath emptyPath = new NBTPathBuilder(utils).create();
```
