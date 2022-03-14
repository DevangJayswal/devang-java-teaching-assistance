# KeyCloak Angular related files
```
client_id=eazypublicclient&
redirect_uri=http%3A%2F%2Flocalhost%3A4200%2Fdashboard&
state=5ec9c197-32f7-4dbc-892a-3800a88a4099&
response_mode=fragment&
response_type=code&
scope=openid&
nonce=b9bff249-2d99-4201-b6d3-f833337d9adc&
code_challenge=NSrRNFNfG30P8i6PF2vmOoKdUBkQr_W8m52UUCCN0VA&
code_challenge_method=S256
```
All these values are being retrieved from the KeyCloak Angular library. We do not need to write any code to do that


## app.module.ts

* function initializeKeycloak(keycloak: KeycloakService)
* ```
  @NgModule({ 
  imports: [ KeycloakAngularModule],
  providers: [...]
  ```

## header.component.html

## header.component.ts

## app-routing.module.ts

* Role based access
  * Of course someone can fool UI application by changing this code but since we have a second level check in the
    backend also it should not be a problem even someone changes that
  * So this kind of role based code on the UI at least will reduce some burden on the backend server to not pass the
    request which are not pass the role based access mechanism.

## auth.route.ts

* class AuthKeyClockGuard
  * Custom class that extends `KeycloakAuthGuard` from the library
  * It provides the out-of-the-box features like :
    * holding the information of whether user is authenticated
    * hold user profile details once the user is authenticated
  * Whenever the protected path will be invoked, this Guard will invoke and all the check will happen like user is
    authenticated and if not show him the login page. else if the user is authenticated set the `authStatus` to `AUTH`
    so our header component will use that to display corresponding tabs
  * Similarly, we will also get the `firstName` and `email` details of the user from the `userProfile` provided by
    Keycloak angular library. All those details will be stored inside a `sessionStorage`, so we can use it in the other
    components and other places of the application
  * `requiredRoles` :  what role this route should accept. For e.g. if the user is trying to access `/dashboard` path 
  you would get all the roles required to that path
  * if the `requiredRoles` is empty then it means that path does not have any role based mechanism, we are 
  returning simply `true`
  * if the `requiredRoles` has some role then check at least one of them role should match with the roles that 
  we are getting from the Keycloak server

So this way Keycloak Angular library provides all the out-of-the-box features and in fact you don't need any interceptor 
also to pass that `access_token` every time to the resource server in the backend. Because the library will take care 
of it internally

# ElecAppUi

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 10.0.4.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change
any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also
use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag
for a production build.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).

## Further help

To get more help on the Angular CLI use `ng help` or go check out
the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).
