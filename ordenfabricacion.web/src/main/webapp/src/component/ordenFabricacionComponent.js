define(['component/_CRUDComponent', 'controller/toolbarController', 'model/toolbarModel', 'model/ordenFabricacionModel', 'controller/ordenFabricacionController'], function() {
    App.Component.OrdenFabricacionComponent = App.Component._CRUDComponent.extend({
        name: 'ordenFabricacion',
        model: App.Model.OrdenFabricacionModel,
        listModel: App.Model.OrdenFabricacionList,
        controller : App.Controller.OrdenFabricacionController
    });
    return App.Component.OrdenFabricacionComponent;
});