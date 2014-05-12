define(['component/_CRUDComponent', 'controller/toolbarController', 'model/toolbarModel', 'model/ordenDespachoModel', 'controller/ordenDespachoController'], function() {
    App.Component.OrdenDespachoComponent = App.Component._CRUDComponent.extend({
        name: 'ordenDespacho',
        model: App.Model.OrdenDespachoModel,
        listModel: App.Model.OrdenDespachoList,
        controller : App.Controller.OrdenDespachoController
    });
    return App.Component.OrdenDespachoComponent;
});