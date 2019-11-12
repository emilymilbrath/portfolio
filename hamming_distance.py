#this program calculates the hamming distance of a language i.e. the lowest hamming distance between any 2 words in that langauge
import re


source = 'EADA, AEEA, CEDB, DBDD, ADCD, ECEE, EBBC, BAAC, DEBE, ACAB'
#input any language (list of words) in source = ''

lang = re.sub(r"[^\w]", " ", source).split()
#regex replaces non alpha characters (commas in this case) with a space, .split() splits string into list where each word is a list item

lowest_dist = len(lang[0])
#sets a variable equal to length of the first word in the language which is the maximum hamming distance could be


for s1 in range(len(lang)):
    dist = 0
    #initialize variable dist to 0 to be increased over iteration
    for s2 in range(1,len(lang)):
    #two for loops iterate over all combinations of 2 words in language
        if len(lang[s1]) != len(lang[s2]):
            raise ValueError("Undefined for sequences of unequal length")
        #hamming distance requires all words to be of equal length, otherwise hamming distance is undefined
        else:
            dist = sum(ch1 != ch2 for ch1,ch2 in zip(lang[s1],lang[s2]))
            #dist is number of characters that do not match between any 2 words in language
            if dist != 0:
                if dist < lowest_dist:
                    lowest_dist = dist
                    #if dist found is less than minimum, make it new minimum


print("Hamming Distance = " + str(lowest_dist))
#output the hamming distance of the language
