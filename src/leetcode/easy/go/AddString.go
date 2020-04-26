package main

import "fmt"

func addStrings(num1 string, num2 string) string {
	rune1 := []rune(num1)
	rune2 := []rune(num2)
	Reverse(rune1)
	Reverse(rune2)

	var res [] rune
	var carry,i rune
	for i=0 ;;i++ {
		res = append(res,carry)
		if i < rune(len(rune1)) {
			res[i] = res[i] + rune1[i]-'0'
		}
		if i < rune(len(rune2)) {
			res[i] = res[i] + rune2[i]-'0'
		}

		carry = res[i] / 10
		res[i] = res[i]%10 + '0'
		if i >= rune(len(rune1)) && i >= rune(len(rune2)) {
			break
		}
	}


	Reverse(res)
	if res[0] == '0' {
		res = res[1:]
	}
	return string(res)
}

func Reverse(runes []rune)  {
	for i, j := 0, len(runes)-1; i < j; i, j = i+1, j-1 {
		runes[i], runes[j] = runes[j], runes[i]
	}
}

func main() {
	fmt.Println(addStrings("1","1"))
}


