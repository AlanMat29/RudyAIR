import { StatutAvion } from './statutAvion';

export class Avion {
  private _id: number | undefined;
  private _ref: string | undefined;
  private _statutAvion: StatutAvion | undefined;

  constructor(id?: number, ref?: string, statutAvion?: StatutAvion) {
    this._id = id;
    this._ref = ref;
    this._statutAvion = statutAvion;
  }

  /**
   * Getter id
   * @return {number }
   */
  public get id(): number | undefined {
    return this._id;
  }

  /**
   * Getter ref
   * @return {string }
   */
  public get ref(): string | undefined {
    return this._ref;
  }

  /**
   * Getter statutAvion
   * @return {StatutAvion }
   */
  public get statutAvion(): StatutAvion | undefined {
    return this._statutAvion;
  }

  /**
   * Setter id
   * @param {number } value
   */
  public set id(value: number | undefined) {
    this._id = value;
  }

  /**
   * Setter ref
   * @param {string } value
   */
  public set ref(value: string | undefined) {
    this._ref = value;
  }

  /**
   * Setter statutAvion
   * @param {StatutAvion } value
   */
  public set statutAvion(value: StatutAvion | undefined) {
    this._statutAvion = value;
  }
}
