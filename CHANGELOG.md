## TerraFirmaCraft v4 for 1.21.1

TerraFirmaCraft for 1.21.1 is here. Our first build for 1.20.1 came out two years ago, and you all may have wondered where we've been. It has not been easy. Working on this mod is like chiseling away a chunk's worth of raw stone, one pixel at a time (remember when you could do that?). TFC itself has grown older too. It's been over ten years now since the first TFC project started, and spawned video games, countless videos, arguments, and most of all hours spent playing survival as it should have been.

This all does not happen by itself. The reason we can deliver this build today to you is due to countless hours of work on behalf of those people who, for reasons unexplainable to even themselves, fight to keep this project alive. The most vital of these people has been @alcatrazEscapee, whose brainpower and work ethic revived this project for modern versions, continuing to innovate and expand the project to meet her ever-growing visions for what TFC should be. This post is to thank her for her long hours spent fighting with Minecraft's internals, the endless tooling and websites she developed for not only TFC but for the entire modding ecosystem, and for her constant drive to push the mod forward. Alcatraz has, at long last, decided to hang up the keyboard once and for all. Wherever she goes (probably the long windy end of a procedurally-generated river) I hope that there's some kaolin clay waiting for her.

Minecraft modding faces an uncertain future. For now, we are happy to roll up our sleeves and continue fighting with this unmaintainable beast of a mod, and we are overjoyed to finally have something new for you to play. I would also like to acknowledge the hard work of @Therighthon and @danielpetkau in getting this build over the finish line. *\-EERussianguy*

Now, for the changelog:

## Calendar

- Days are now 24 real life minutes long by default

- Sunrise and sunset times vary by latitude and season

    - No variance at “equators” (max temperature bands)

    - Varies between midnight sun in summers and polar nights in winters at the poles (minimum temperature bands)

    - Adjusting the “Temperature Scale” setting on world generation will change the locations of poles and equators


## Climate

- Time of year is now flipped between “northern” (default spawn location) and “southern” hemispheres

    - Northern and southern hemispheres alternate infinitely if you travel far enough north or south, with the hemisphere switching polarity every time you cross an equator

    - This effects crops, fruits, foliage colors and textures, and anything else that relies on the current temperature or time of year

- Expanded the list of Koppen climates distinguished by the inventory menu

- Added wet and dry seasons

    - Rainfall now varies throughout the year, peaking on either July 1, or August 1, depending on the location

    - The amount by which rainfall varies also depends on the location, with wet season peaks as much as 200% the annual average, and dry season lows as low as 0% of the annual average

    - This effects crops, fruit trees/bushes, and frequency of rain

    - Dry-summer “coastal” climates typically occur in thin bands on the west coasts in Northern hemispheres, with low-variance continental climates farther inland, and wet-summer monsoon climates on east coasts of sufficiently large continents. This is reversed in southern hemispheres

- Reduced seasonal temperature variation to zero at the equator


## Decorative Plants

- Now use a custom baked model to update textures seasonally

    - This allows textures to change without updating blocks

    - Some plants now vary by time of day, like Sacred Daturas and Morning Glory

    - When near the equator, plants will choose a random point in their seasonal cycle. This means that at least some of the Blood Lilies on a given patch of Kaolin Clay will be blooming at any given time

- Added many new decorative plants, especially for tundra and tropical climates

- Most plants have had their climate requirements modified to accommodate wet/dry seasons


## Fruit Trees

- Time since planted now carries over from the sapling to the trunk blocks. Previously, no matter how long you left a sapling unloaded, it would only grow into a single trunk when it next ticked. Now it can grow into an entire tree if left long enough in the correct climate conditions.

- Fruiting times are affected by what hemisphere the tree is planted in, and hydration is impacted by wet/dry seasons.


## Crops/Farming

- Added 6 new crops!

    - Peanuts

    - Lentils

    - Cassava

    - Alfalfa

    - Radishes

    - Canola

- New Soil Nutrient Mechanics

    - Each crop has unique profile of nutrients in uptakes/supplies to the soil

- Most crops fit into one of four categories:

    - Legumes/Nitrogen Fixers: Consume P/K to produce a large amount of N

    - Cereal Grains: Consume large amounts of N to produce P/K

    - Vegetables: Consume all three nutrients, but provide highly nutritious food items

    - Cover crops: Produce all three nutrients, but provide largely worthless products

- Altered Crop Climate Ranges

    - New values more suitable for how 1.21 handles climate

- New Hydration Mechanics

    - Reduced the effect of recent rainfall on soil hydration to avoid erratic hydration levels

    - Increased the effect of seasonal rainfall variation to compensate

    - Hydration from nearby waterblocks is now a flat +40 hydration when within 4 blocks of water

    - Gravel/Sand placed under farmland blocks halves the total hydration level of that block

    - Clay placed under farmland blocks doubles the total hydration level of that block

* Soils give bonuses to nutrient addition from fertilizers/plants based on their grade

    - Very Rich: +20% (Mollisols)

    - Rich: +10% (Andisols, Fluvisols, Alfisols)

    - Normal: +0% (Entisols)

    - Poor: -10% (Aridisols, Podzols)

    - Very Poor: -20% (Oxisols)


## Animals

- New Animals

    - New pests, partially replacing rats in different climates

        - Lemmings (cold)

        - Jerboas (dry)

        - Mongeese (tropical)

    - Bison - A new type of ramming animal found in temperate grasslands

    - Seals - Marine mammals that flee to shore when chased by orcas, and drop blubber

- Updated textures and models for many animals, courtesy of Dodo

- Ramming animals, such as moose and boars now actually ram things more often


## World Generation

### General

- Dirt

- Now uses 8 different soil types, rather than 4

    - Entisols (Default)

    - Aridisols (Dry/extremely cold)

    - Mollisols (Cold plains biomes)

    - Alfisols (Temperate deciduous forests)

    - Podzols (Coniferous forests)

    - Andisols (Volcanic biomes)

    - Fluvisols (Near rivers in biomes with high rain variance)

    - Oxisols (In the humid tropics)

- In addition, each type of dirt has new variants, including

    - Coarse dirt (found in dry climates)

    - Duff (Found in forests instead of grass)

- Soils vary in quality, see Crops/Farming


### Kaolin Clay

- Increased the number of biomes it can generate in

- Shield volcanoes in particular are helpful in this respect, as they like to generate in the middle of otherwise empty oceans

- Blood lilies should be more recognizable at all times of the year, as mentioned in the Decorative Plants section


### New Biomes

- Increased the number of biomes from the 30 that existed in 1.20 to **109,** including but not limited to the following:

* Shield Volcanoes

    - Vary in age and volcanic activity, and generate in long chains

    - Form islands when generated in oceans, or just large mountains when inland

    - Dormant (and older) shield volcanoes are home to tuff rings

* Ice Sheets

    - Solid sheets of ice that can cover continents

    - In volcanically active areas, tuyas can form, poking through the ice sheets

    - Subglacial lakes may hide under the surface

* Glaciated Biomes

    - Mountains and shield volcanoes can form with glaciers on their flanks, and ice sheets at their bases

* Periglacial biomes

    - Located at the fringes of ice sheets, these biomes were shaped by the last ice age, or by the frigid conditions that still linger there now

    - Glacially carved mountains, drumlins, patterned ground, exposed tuyas, and more

* Dunes

    - Can be sandy, or grass topped

    - Found in dry climates

* Flats

    - Can be mud or salt flats

    - Found in very dry climates

* Canyons, Mesas, Buttes, and Hoodoos

    - Replace the old inverted badlands biome

    - More common in dry climates, but can occur in wet climates as well with stone instead of sandstone

    - Along with Whorled Canyons and Badlands, these biomes now use different block palettes when the surface rock is mafic volcanic, or karst

* Whorled Canyons

    - Wavy sandstone formations found in dry climates

* Guano Islands

    - Rocky islands covered in guano

* Karst Biomes

    - A huge new category of biomes that generate when the surface stone type is a flux stone

    - Caves are more common in these biomes

    - The type of karst morphologies vary with temperature and rainfall. In approximate cold/dry to hot/wet order:

        - “Burren” karsts, inspired by the bare karst terrain of Burren, Ireland

        - Dolines, subtle shallow depressions

        - Cenotes, deep, shear sided sinkholes

        - “Shilin” karsts, inspired by the “stone forests” of Shilin, China

        - Tower karsts, inspired by Ha Long bay, et. al.

* Shore Biomes 

  - Rather than using the same shore biome everywhere, the shore biome is now selected based on the land biome nearest the coast

- Beach sand is no longer tied to rock layers, but varies randomly or with climate. White, yellow, red, and brown sand can be found commonly, black and green sand are limited to shield volcanoes, and pink sand to warm, wet climates.

- Beaches may be made up of sand or gravel, depending on the shore type and climate

- Different “tides” at different locations. The water level does not actually change, but some beaches will have more area above the water than others, and underwater creatures may be stranded above the water.

- Sea stacks occur at the edges of plateaus and other high biomes

- Terraces occur at the edges of old mountains, and consist of shear ocean cliffs with a second layer of cliffs farther from the shore

- Setback cliffs occur at the edges of medium-high biomes, and have shear cliffs behind foreshore dunes

- Coastal dunes occur at the edges of medium to low biomes

- Rocky shores feature large tidepools and wave-carved cliffs and sea caves, and occur near medium height biomes

- Embayments feature small beaches surrounded by rocky outcroppings. They occur near medium to low biomes


### Rivers

- Rainfall no longer sharply increases around rivers, leading to odd-shaped storms. Grass will still be greener and water-loving plants will still generate, but there will not be extra visual rain. Also, these effects will not occur for underground rivers

- New blend types for different biomes, adding variety to the canyons cut by rivers


### Forests

- Reworked the forest type system to have many new forest types that can affect the number of tree species found there (from 1 in monocultures, to 3 in diverse forests), the density of trees, and the types of flora and fauna.

- Areas with the shrubland forest type generate only the small shrubs, not full sized trees

- Savanna forest types generate sparse trees, and may also have shrubs

- Bamboo forests may also generate where bamboos or other plants have out-competed the trees

- Climate parameters for trees have been tweaked to take advantage of rainfall seasonality


## Devices

- New Kiln multiblocks for batch-firing ceramics

- Revised the blast furnace structure to not require all those annoying little sheet blocks


## Misc

- Metal-plated blocks weather like vanilla copper, depending on the metal type

- Rendering for items placed with V has changed, including custom rendering for some ceramics

- Log piles reworked to be GUI-free and hold any combination of logs

- Placed metal sheets removed
