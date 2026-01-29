# Use official Go image as builder
FROM golang:1.25-alpine AS builder

# Set working directory inside container
WORKDIR /app

# Copy go module files
COPY go.mod ./

# Download dependencies
RUN go mod download

# Copy source code
COPY main.go ./

# Build the application
RUN CGO_ENABLED=0 GOOS=linux go build -o go-hello-world

# Use a minimal Alpine image for the final stage
FROM alpine:latest

# Install CA certificates for HTTPS capabilities (optional but recommended)
RUN apk --no-cache add ca-certificates

# Set working directory
WORKDIR /root/

# Copy the binary from builder stage
COPY --from=builder /app/go-hello-world .

# Expose port 8080
EXPOSE 8080

# Command to run the application
CMD ["./go-hello-world"]