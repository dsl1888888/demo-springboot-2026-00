//package main
//
//import (
//	"fmt"
//)
//
////TIP <p>To run your code, right-click the code and select <b>Run</b>.</p> <p>Alternatively, click
//// the <icon src="AllIcons.Actions.Execute"/> icon in the gutter and select the <b>Run</b> menu item from here.</p>
//func main() {
//	//TIP <p>Press <shortcut actionId="ShowIntentionActions"/> when your caret is at the underlined text
//	// to see how GoLand suggests fixing the warning.</p><p>Alternatively, if available, click the lightbulb to view possible fixes.</p>
//	s := "gopher"
//	fmt.Printf("Hello and welcome, %s!\n", s)
//
//	for i := 1; i <= 5; i++ {
//		//TIP <p>To start your debugging session, right-click your code in the editor and select the Debug option.</p> <p>We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//		// for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.</p>
//		fmt.Println("i =", 100/i)
//	}
//}

package main

import (
	"encoding/json"
	"fmt"
	"net/http"
)

// Response struct to hold the JSON structure
type Response struct {
	Message string `json:"message"`
}

func helloWorldHandler(w http.ResponseWriter, r *http.Request) {
	// Create a response object with the message
	response := Response{
		Message: "Hello, World!",
	}

	// Set content type to application/json
	w.Header().Set("Content-Type", "application/json")

	// Write the JSON response
	w.WriteHeader(http.StatusOK)
	json.NewEncoder(w).Encode(response)
}

func main() {
	// Define the route and handler function
	http.HandleFunc("/1", helloWorldHandler)
	http.HandleFunc("/2", helloWorldHandler)
	http.HandleFunc("/3", helloWorldHandler)
	http.HandleFunc("/hello", helloWorldHandler)
	//http.HandleFunc("/", helloWorldHandler) // 这个很奇怪,乱输入路由，至少会匹配到这个主路由

	// Start the server on port 8080
	fmt.Println("Starting server on :8080")
	if err := http.ListenAndServe(":8080", nil); err != nil {
		fmt.Println("Error starting server:", err)
	}
}

//http://localhost:8080/hello
