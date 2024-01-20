# syntax=docker/dockerfile:1
FROM node:20-alpine as build
WORKDIR /ng-app
COPY package*.json .
RUN npm ci
COPY . .
RUN npm run build

FROM nginx:alpine as runtime
ENV API_URL http://localhost:8080/api
COPY --from=build /ng-app/dist/frontend/browser /usr/share/nginx/html
COPY ./nginx/templates/default.conf.template /etc/nginx/templates/
EXPOSE 80