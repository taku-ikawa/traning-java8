// -scripting をつけて実行が必要
// ちなみに以下のような正規表現が使えなかった
// List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

var text = readFully("word.txt");
var wordList = java.util.Arrays.asList(text.split("\n"));
var longWordList = new java.util.ArrayList();
for each (var word in wordList)
    if(word.length() >= 12)
    	longWordList.add(word);
java.util.Collections.sort(longWordList);
for each (var word in longWordList)
    print(word);

