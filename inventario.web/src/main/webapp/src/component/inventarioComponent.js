define(['component/_CRUDComponent', 'controller/toolbarController', 'model/toolbarModel', 'model/inventarioModel', 'controller/inventarioController'], function() {
    App.Component.InventarioComponent = App.Component._CRUDComponent.extend({
        name: 'inventario',
        model: App.Model.InventarioModel,
        listModel: App.Model.InventarioList,
        controller : App.Controller.InventarioController
    });
    return App.Component.InventarioComponent;
});