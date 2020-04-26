package main

import (
	"fmt"
	"strings"
)

func toLowerCase3(str string) string {
	return strings.ToLower(str)
}

func toLowerCase(str string) string {
	var out strings.Builder
	for _, ch := range str {
		if ch >= 'A' && ch <= 'Z' {
			out.WriteByte(byte(ch + 32))
		}else {
			out.WriteByte(byte(ch))
		}
	}
	return out.String()
}

func toLowerCase2(str string) string {
	if len(str) == 0 {
		return ""
	}

	var output string
	for i:=0 ; i<len(str) ;i++ {
		if str[i] >= 'A' && str[i] <= 'Z' {
			output = output + string(str[i] + 'a'-'A')
		}else {
			output = output + string(str[i])
		}
	}

	return output
}

func main() {
	fmt.Println(toLowerCase("Usdf,sFHKJFCSN "))
}